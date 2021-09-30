package com.attrecto.academy.android.model.dto

import com.attrecto.academy.android.model.domain.Movie
import com.squareup.moshi.Json

data class MovieDetailDto(
    @Json(name = "Plot")
    val plot: String?,
    @Json(name = "Poster")
    val poster: String?,
    @Json(name = "Title")
    val title: String?,
    @Json(name = "Year")
    val year: String?,
    @Json(name = "imdbID")
    val imdbId: String?,
    @Json(name = "imdbRating")
    val imdbRating: Float?
)

fun MovieDetailDto.asMovie() = Movie(
    title = title.orEmpty(),
    year = year?.toIntOrNull() ?: 0,
    imdbId = imdbId.orEmpty(),
    imdbRating = imdbRating ?: 0f,
    poster = poster.orEmpty(),
    plot = plot.orEmpty()
)