package com.example.diceroller

import ScryfallCard
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.io.InputStream
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection


// this is the main activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
        var lifeTotal = 40
        val textView: TextView = findViewById(R.id.lifeTotalText)
        textView.text = lifeTotal.toString()
        val minusButton: Button = findViewById(R.id.buttonMinus)
        val plusButton: Button = findViewById(R.id.buttonPlus)

        plusButton.setOnClickListener {
            lifeTotal += 1
            textView.text = lifeTotal.toString()
        }

        minusButton.setOnClickListener {
            lifeTotal -= 1
            textView.text = lifeTotal.toString()
        }

        val testAPIButton: Button = findViewById(R.id.APITestButton)
        val cardImageView: ImageView = findViewById(R.id.cardImage)
        var currentCard: ScryfallCard = ScryfallCard()
        val imageHandler: CompletionHandler

        testAPIButton.setOnClickListener {
            GlobalScope.launch {
                loadCardImage()
            }
        }
    }

    internal val Background = newFixedThreadPoolContext(2, "bg")

    private suspend fun getCard(): ScryfallCard {
        return GlobalScope.async<ScryfallCard> {
            delay(100L)
            val jsonString = URL("https://api.scryfall.com/cards/random").readText()
            val json = Json(JsonConfiguration(ignoreUnknownKeys = true))
            val card: ScryfallCard = json.parse(ScryfallCard.serializer(), jsonString)
            card
        }.await()
    }

    private suspend fun loadCardImage(){
        val currentCard: ScryfallCard = getCard()
        val testAPITextView: TextView = findViewById(R.id.jsonPreview)
        val cardImageView: ImageView = findViewById(R.id.cardImage)
        testAPITextView.text = currentCard.name
        GlobalScope.launch(Background) {
            val bitmap = getBitmapFromURL(currentCard.imageUris?.normal)
            GlobalScope.launch(Dispatchers.Main) {
                cardImageView.setImageBitmap(bitmap)
            }
        }
    }

    fun getBitmapFromURL(src: String?): Bitmap? {
            val url = URL(src)
            val connection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
            connection.setDoInput(true)
            connection.connect()
            val input = connection.getInputStream()
            return BitmapFactory.decodeStream(input)
    }

    private fun rollDice() {
        // make a new die and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceText: TextView = findViewById(R.id.diceRollText)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
        diceText.text = diceRoll.toString()
    }


}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}