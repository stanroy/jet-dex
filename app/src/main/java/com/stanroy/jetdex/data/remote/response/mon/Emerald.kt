package com.stanroy.jetdex.data.remote.response.mon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emerald(
    @SerialName("front_default")
    val frontDefault: String,
    @SerialName("front_shiny")
    val frontShiny: String
)