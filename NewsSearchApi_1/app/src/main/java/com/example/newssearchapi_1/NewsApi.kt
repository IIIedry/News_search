package com.example.newssearchapi_1

import androidx.annotation.IntRange
import com.example.newssearchapi_1.models.Article
import com.example.newssearchapi_1.models.Response
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType

import okhttp3.OkHttpClient
import org.intellij.lang.annotations.Language
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

interface NewsApi{
    @GET("/everything")
    suspend fun everything(
        @Query("q") query: String? = null,
        @Query("from") from: Date? = null,
        @Query("to") to: String? = null,
        @Query("language") language: List<Language>? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("pageSize") @IntRange(from= 0, to = 100) pageSize: Int = 100,
        @Query("page") @IntRange(from = 1) page: Int = 1,
    ): Result<Response<Article>>
}

fun NewsApi(
    baseUrl: String,
    okHttpClient: OkHttpClient? = null,
    json: Json = Json,
): NewsApi{
    return retrofit(baseUrl, okHttpClient, json).create()
}

private fun retrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient?,
    json: Json,
): Retrofit {
    val jsonConverterFactory = json.asConverterFactory("application/json".toMediaType())
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .run{ if(okHttpClient != null) client(okHttpClient) else this}
        .build()
}
