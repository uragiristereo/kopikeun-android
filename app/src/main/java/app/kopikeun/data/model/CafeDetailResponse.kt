package app.kopikeun.data.model

import app.kopikeun.domain.entity.cafe.CafeDetail

data class CafeDetailResponse(
    val msg: String,
    val data: CafeDetail,
)
