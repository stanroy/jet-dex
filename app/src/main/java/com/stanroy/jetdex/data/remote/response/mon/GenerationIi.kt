package com.stanroy.jetdex.data.remote.response.mon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIi(
    @SerialName("crystal")
    val crystal: Crystal,
    @SerialName("gold")
    val gold: Gold,
    @SerialName("silver")
    val silver: Silver
)