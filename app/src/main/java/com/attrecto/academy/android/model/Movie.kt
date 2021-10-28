package com.attrecto.academy.android.model

data class Movie(
    val title: String,
    val year: Int,
    val imdbId: String,
    val imdbRating: Float,
    val poster: String,
    val plot: String
)