package com.example.newsapp1.data

import com.google.gson.annotations.SerializedName

data class HeadlinesResponse(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null,
    @SerializedName("articles")
    val articles: List<Article>? = null,
)

data class Article(
    @SerializedName("source")
    val source: ArticleSource,
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("urlToImage")
    val imageUrl: String? = null,
)

data class ArticleSource(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)
