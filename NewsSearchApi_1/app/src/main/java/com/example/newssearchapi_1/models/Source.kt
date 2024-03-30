package com.example.newssearchapi_1.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Source(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
)