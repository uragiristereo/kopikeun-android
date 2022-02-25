package app.kopikeun.domain.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val id: Int,
    @field:Json(name = "photo_url")
    val photoUrl: String,
) : Parcelable
