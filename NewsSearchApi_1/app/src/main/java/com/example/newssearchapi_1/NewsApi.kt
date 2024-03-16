package com.example.newssearchapi_1

import kotlinx.serialization.SerialName
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

interface NewsApi{
    @GET("/everything")
    fun everything(
        @Query("q") query: String? = null,
        @Query("from") from: Date? = null,
        @Query("to") to: String? = null,
        @Query("to") language: String? = null,
        @Query("sortBy") sortBy: String? = null,
    )
}