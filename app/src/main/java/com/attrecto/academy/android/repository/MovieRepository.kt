package com.attrecto.academy.android.repository

import com.attrecto.academy.android.data.api.Network
import com.attrecto.academy.android.model.dto.asMovie
import com.attrecto.academy.android.model.dto.asMovieList

class MovieRepository {
    suspend fun getMovieList(keyword: String) = Network.moviesApi.search(keyword).asMovieList()

    suspend fun getMovie(imdbId: String) = Network.moviesApi.getDetail(imdbId).asMovie()
}