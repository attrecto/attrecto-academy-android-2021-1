package com.attrecto.academy.android.repository

import com.attrecto.academy.android.model.Movie

class EmptyMovieRepository : MovieRepository {
    override suspend fun getMovieList(keyword: String): List<Movie> {
        return emptyList()
    }
}