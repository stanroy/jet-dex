package com.stanroy.jetdex.data.remote.response.mon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIii(
    @SerialName("emerald")
    val emerald: Emerald,
    @SerialName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen,
    @SerialName("ruby-sapphire")
    val rubySapphire: RubySapphire
)