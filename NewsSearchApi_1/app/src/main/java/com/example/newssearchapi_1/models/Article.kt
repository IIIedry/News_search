package com.example.newssearchapi_1.models

import com.example.newssearchapi_1.utils.DateTimeUTCSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Article(
    @SerialName("source") val source: Source,
    @SerialName("author") val author: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("url") val url: String,
    @SerialName("urlToImage") val urlToImage: String,
    @SerialName("publishedAt")
    @Serializable(with = DateTimeUTCSerializer::class)
    val publishedAt: Date,
    @SerialName("content") val content: String,
)
