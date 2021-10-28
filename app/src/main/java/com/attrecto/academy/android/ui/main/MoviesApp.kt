package com.attrecto.academy.android.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.attrecto.academy.android.DetailScreen
import com.attrecto.academy.android.ListScreen

@Composable
fun MoviesApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.List.route
    ) {
        composable(route = Screen.List.route) {
            ListScreen(navController)
        }
        composable(route = Screen.Detail.route) {
            val imdbId = it.arguments?.getString(Screen.IMDB_ID)
            DetailScreen(imdbId.orEmpty())
        }
    }
}