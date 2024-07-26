package com.stanroy.jetdex.data.remote.response.mon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityX(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)