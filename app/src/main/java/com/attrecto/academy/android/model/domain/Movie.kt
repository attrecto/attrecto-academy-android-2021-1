package com.attrecto.academy.android.model.domain

data class Movie(
    val title: String,
    val year: Int,
    val imdbId: String,
    val imdbRating: Float = 0f,
    val poster: String,
    val plot: String = ""
)