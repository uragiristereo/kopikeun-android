package app.kopikeun.domain.entity.cafe

import app.kopikeun.domain.entity.Menu
import app.kopikeun.domain.entity.Photo
import com.squareup.moshi.Json

data class CafeDetail(
    val id: Int,
    val name: String,
    @field:Json(name = "logo_url")
    val logoUrl: String,
    @field:Json(name = "rating_count")
    val ratingCount: Int,
    @field:Json(name = "rating_dec")
    val ratingDec: Float,
    val menus: List<Menu>,
    val photos: List<Photo>,
    val contact: Contact,
)
