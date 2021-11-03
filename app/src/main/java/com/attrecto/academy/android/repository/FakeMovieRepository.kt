package com.attrecto.academy.android.repository

import com.attrecto.academy.android.model.Movie

class FakeMovieRepository : MovieRepository {
    override suspend fun getMovieList(keyword: String): List<Movie> {
        TODO("Not yet implemented")
    }
}