// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json         = Json(JsonConfiguration.Stable)
// val scryfallCard = json.parse(ScryfallCard.serializer(), jsonString)

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.internal.*

@Serializable
data class ScryfallCard (
    @SerialName("object")
    val scryfallCardObject: String? = null,

    val id: String? = null,

    @SerialName("oracle_id")
    val oracleID: String? = null,

    @SerialName("multiverse_ids")
    val multiverseIDS: List<Long>? = null,

    @SerialName("tcgplayer_id")
    val tcgplayerID: Long? = null,

    val name: String? = null,
    val lang: String? = null,

    @SerialName("released_at")
    val releasedAt: String? = null,

    val uri: String? = null,

    @SerialName("scryfall_uri")
    val scryfallURI: String? = null,

    val layout: String? = null,

    @SerialName("highres_image")
    val highresImage: Boolean? = null,

    @SerialName("image_uris")
    val imageUris: ImageUris? = null,

    @SerialName("mana_cost")
    val manaCost: String? = null,

    val cmc: Float? = null,

    @SerialName("type_line")
    val typeLine: String? = null,

    @SerialName("oracle_text")
    val oracleText: String? = null,

    val colors: List<String>? = null,

    @SerialName("color_identity")
    val colorIdentity: List<String>? = null,

    val keywords: JsonArray? = null,
    val legalities: Legalities? = null,
    val games: List<String>? = null,
    val reserved: Boolean? = null,
    val foil: Boolean? = null,
    val nonfoil: Boolean? = null,
    val oversized: Boolean? = null,
    val promo: Boolean? = null,
    val reprint: Boolean? = null,
    val variation: Boolean? = null,
    val set: String? = null,

    @SerialName("set_name")
    val setName: String? = null,

    @SerialName("set_type")
    val setType: String? = null,

    @SerialName("set_uri")
    val setURI: String? = null,

    @SerialName("set_search_uri")
    val setSearchURI: String? = null,

    @SerialName("scryfall_set_uri")
    val scryfallSetURI: String? = null,

    @SerialName("rulings_uri")
    val rulingsURI: String? = null,

    @SerialName("prints_search_uri")
    val printsSearchURI: String? = null,

    @SerialName("collector_number")
    val collectorNumber: String? = null,

    val digital: Boolean? = null,
    val rarity: String? = null,

    @SerialName("card_back_id")
    val cardBackID: String? = null,

    val artist: String? = null,

    @SerialName("artist_ids")
    val artistIDS: List<String>? = null,

    @SerialName("illustration_id")
    val illustrationID: String? = null,

    @SerialName("border_color")
    val borderColor: String? = null,

    val frame: String? = null,

    @SerialName("full_art")
    val fullArt: Boolean? = null,

    val textless: Boolean? = null,
    val booster: Boolean? = null,

    @SerialName("story_spotlight")
    val storySpotlight: Boolean? = null,

    @SerialName("edhrec_rank")
    val edhrecRank: Long? = null,

    val prices: Prices? = null,

    @SerialName("related_uris")
    val relatedUris: RelatedUris? = null,

    @SerialName("purchase_uris")
    val purchaseUris: PurchaseUris? = null
)

@Serializable
data class ImageUris (
    val small: String? = null,
    val normal: String? = null,
    val large: String? = null,
    val png: String? = null,

    @SerialName("art_crop")
    val artCrop: String? = null,

    @SerialName("border_crop")
    val borderCrop: String? = null
)

@Serializable
data class Legalities (
    val standard: String? = null,
    val future: String? = null,
    val historic: String? = null,
    val pioneer: String? = null,
    val modern: String? = null,
    val legacy: String? = null,
    val pauper: String? = null,
    val vintage: String? = null,
    val penny: String? = null,
    val commander: String? = null,
    val brawl: String? = null,
    val duel: String? = null,
    val oldschool: String? = null
)

@Serializable
data class Prices (
    val usd: String? = null,

    @SerialName("usd_foil")
    val usdFoil: String? = null,

    val eur: String? = null,
    val tix: String? = null
)

@Serializable
data class PurchaseUris (
    val tcgplayer: String? = null,
    val cardmarket: String? = null,
    val cardhoarder: String? = null
)

@Serializable
data class RelatedUris (
    val gatherer: String? = null,

    @SerialName("tcgplayer_decks")
    val tcgplayerDecks: String? = null,

    val edhrec: String? = null,
    val mtgtop8: String? = null
)
