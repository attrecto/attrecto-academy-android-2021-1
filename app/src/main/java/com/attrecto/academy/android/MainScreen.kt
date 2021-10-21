package com.attrecto.academy.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.List.path
    ) {
        composable(Screen.List.path) {
            ListScreen(navController = navController)
        }
        composable(Screen.Detail.path){
            DetailsScreen()
        }
    }
}