package com.attrecto.academy.android

sealed class Screen(val route: String) {
    companion object {
        const val IMDB_ID = "imdbId"
    }

    object List : Screen("list")
    object Detail : Screen("detail/{$IMDB_ID}") {
        fun route(imdbId: String) = "detail/$imdbId"
    }
}