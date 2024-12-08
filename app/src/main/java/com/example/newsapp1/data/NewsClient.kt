package com.example.newsapp1.data

import retrofit2.http.GET
import retrofit2.http.Query


interface NewsClient {
    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String,
    ): HeadlinesResponse?

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("apiKey") apiKey: String,
        @Query("q") searchQuery: String,
    ): HeadlinesResponse?
}
