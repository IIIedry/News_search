package com.example.newssearchapi_1

import androidx.annotation.IntRange
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import org.intellij.lang.annotations.Language
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

interface NewsApi{
    @GET("/everything")
    fun everything(
        @Query("q") query: String? = null,
        @Query("from") from: Date? = null,
        @Query("to") to: String? = null,
        @Query("to") language: List<Language>? = null, //қате болуы мүмкін
        @Query("sortBy") sortBy: String? = null,
        @Query("pageSize") @IntRange(from= 0, to = 100) pageSize: Int = 100,
        @Query("page") @IntRange(from = 1) page: Int = 1,
    )
}
