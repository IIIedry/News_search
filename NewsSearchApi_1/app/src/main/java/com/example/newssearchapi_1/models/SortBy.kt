package com.example.newssearchapi_1.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
enum class SortBy {
    @SerialName("relevancy")
    RELEVANCY,

    @SerialName("popularity")
    POPULARITY,

    @SerialName("publishedAt")
    PUBLISHED_AT,
}