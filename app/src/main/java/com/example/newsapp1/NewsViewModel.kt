package com.example.newsapp1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp1.data.Article
import com.example.newsapp1.data.NewsAPIInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles : MutableLiveData<List<Article>> = _articles

    init {
        fetchNewsTopHeadlines()
    }

    fun fetchNewsTopHeadlines(category: String = "GENERAL") {
        viewModelScope.launch(Dispatchers.IO) {
            val response = NewsAPIInstance.api.getHeadlines(
                apiKey = Constant.apiKey,
                country = "us",
                category = category
            )
            _articles.postValue(response?.articles)
        }
    }

    fun fetchEverythingWithQuery(query : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = NewsAPIInstance.api.getEverything(
                apiKey = Constant.apiKey,
                searchQuery = query
            )
            _articles.postValue(response?.articles)
        }
    }
}

