package com.example.newsapp1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun Navigation(
    newsViewModel: NewsViewModel
){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomePageScreen) {
        composable<HomePageScreen>{
            HomePage(newsViewModel, navController)
        }
        composable<NewsArticleScreen>{
            val args = it.toRoute<NewsArticleScreen>()
            NewsArticle(args.url)
        }
    }
}
