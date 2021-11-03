package com.attrecto.academy.android.data.api

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