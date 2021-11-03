package com.attrecto.academy.android.repository

import com.attrecto.academy.android.model.Movie

interface MovieRepository {
    suspend fun getMovieList(keyword: String): List<Movie>
}