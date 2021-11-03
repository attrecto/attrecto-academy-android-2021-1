package com.attrecto.academy.android.di

import com.attrecto.academy.android.repository.EmptyMovieRepository
import com.attrecto.academy.android.repository.MovieRepository

fun provideMovieRepository(): MovieRepository {
    return EmptyMovieRepository()
}