package app.kopikeun.domain.entity

import com.squareup.moshi.Json

data class Tokens(
    @field:Json(name = "access_token")
    val accessToken: String?,
    @field:Json(name = "refresh_token")
    val refreshToken: String?,
)
