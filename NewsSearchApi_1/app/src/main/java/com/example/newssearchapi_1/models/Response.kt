package com.example.newssearchapi_1.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response<E>(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: Int,
    @SerialName("articles") val articles: List<Article>
)