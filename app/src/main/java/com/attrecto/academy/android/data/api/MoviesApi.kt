package com.attrecto.academy.android.data.api

import com.attrecto.academy.android.data.api.Endpoint.Movies.VALUE_API_KEY
import com.attrecto.academy.android.model.dto.MovieDetailDto
import com.attrecto.academy.android.model.dto.MovieSearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET(".")
    suspend fun search(
        @Query(Endpoint.Movies.QUERY_SEARCH) title: String,
        @Query(Endpoint.Movies.QUERY_API_KEY) apiKey: String = VALUE_API_KEY
    ): MovieSearchDto

    @GET(".")
    suspend fun getDetail(
        @Query(Endpoint.Movies.QUERY_ID) imdbId: String,
        @Query(Endpoint.Movies.QUERY_PLOT) plot: String = Endpoint.Movies.VALUE_PLOT,
        @Query(Endpoint.Movies.QUERY_API_KEY) apiKey: String = VALUE_API_KEY
    ): MovieDetailDto
}