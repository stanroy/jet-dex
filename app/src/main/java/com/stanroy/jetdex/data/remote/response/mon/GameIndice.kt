package com.stanroy.jetdex.data.remote.response.mon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameIndice(
    @SerialName("game_index")
    val gameIndex: Int,
    @SerialName("version")
    val version: Version
)