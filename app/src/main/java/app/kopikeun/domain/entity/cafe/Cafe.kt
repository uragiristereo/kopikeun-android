package app.kopikeun.domain.entity.cafe

import app.kopikeun.domain.entity.Photo
import com.squareup.moshi.Json

data class Cafe(
    val id: Int,
    val name: String,
    @field:Json(name = "logo_url")
    val logoUrl: String,
    val photo: Photo?,
    @field:Json(name = "rating_count")
    val ratingCount: Int,
    @field:Json(name = "rating_dec")
    val ratingDec: String,
    val contact: Contact?,
)
