package app.kopikeun.data.model

import app.kopikeun.domain.entity.cafe.Cafe

data class SearchResponse(
    val msg: String,
    val data: List<Cafe>,
)
