package app.kopikeun.data.model

import app.kopikeun.domain.entity.cafe.Cafe

data class CafeResponse(
    val msg: String,
    val data: Cafe?,
)
