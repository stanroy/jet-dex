package com.stanroy.jetdex.data.remote.response.mon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationI(
    @SerialName("red-blue")
    val redBlue: RedBlue,
    @SerialName("yellow")
    val yellow: Yellow
)