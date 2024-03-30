package com.example.newssearchapi_1

import androidx.annotation.IntRange
import com.example.newssearchapi_1.models.Article
import com.example.newssearchapi_1.models.Response
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import okhttp3.OkHttpClient
import org.intellij.lang.annotations.Language
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

interface NewsApi{
    /**
     * Api details [here](https://newsapi.org/docs/endpoints/everything)
     */
    @GET("/everything")
    suspend fun everything(
        @Query("q") query: String? = null,
        @Query("from") from: Date? = null,
        @Query("to") to: String? = null,
        @Query("language") language: List<Language>? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("pageSize") @IntRange(from= 0, to = 100) pageSize: Int = 100,
        @Query("page") @IntRange(from = 1) page: Int = 1,
    ): Response<Article>
}

fun NewsApi(
    baseUrl: String,
    okHttpClient: OkHttpClient? = null,

): NewsApi{
    val retrofit = retrofit(baseUrl, okHttpClient)
    return retrofit.create()
}

private fun retrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient?
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .run{ if(okHttpClient != null) client(okHttpClient) else this}
        .
        .build()
}
