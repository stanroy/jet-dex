package com.stanroy.jetdex.data.remote.response.list


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)