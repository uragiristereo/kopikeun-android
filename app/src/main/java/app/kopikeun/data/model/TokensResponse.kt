package app.kopikeun.data.model

import app.kopikeun.domain.entity.Tokens

data class TokensResponse(
    val msg: String,
    val data: Tokens?,
)
