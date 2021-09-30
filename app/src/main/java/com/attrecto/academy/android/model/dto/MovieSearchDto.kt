package com.attrecto.academy.android.model.dto

import com.attrecto.academy.android.model.domain.Movie
import com.squareup.moshi.Json

data class MovieSearchDto(
    @Json(name = "Search")
    val items: List<MovieItemDto>?
)

data class MovieItemDto(
    @Json(name = "Title")
    val title: String?,
    @Json(name = "Year")
    val year: String?,
    @Json(name = "imdbID")
    val imdbId: String?,
    @Json(name = "Poster")
    val poster: String?
)

fun MovieItemDto.asMovie() = Movie(
    title = title.orEmpty(),
    year = year?.toIntOrNull() ?: 0,
    imdbId = imdbId.orEmpty(),
    poster = poster.orEmpty()
)

fun MovieSearchDto.asMovieList() = items?.map { it.asMovie() } ?: emptyList()