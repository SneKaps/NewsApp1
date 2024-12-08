package com.example.newsapp1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsAPIInstance {
    private const val BASE_URL = "https://newsapi.org"

    val api: NewsClient by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsClient::class.java)
    }
}