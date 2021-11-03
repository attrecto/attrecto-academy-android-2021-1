package com.attrecto.academy.android.di

import com.attrecto.academy.android.repository.EmptyMovieRepository
import com.attrecto.academy.android.repository.MovieRepository


fun provideMovieRepository(): MovieRepository {
    /*
        3. Feladat
        8. Feladat

        Itt kell megadni melyik implementációját használjuk a MovieRepository-nak.
     */

    return EmptyMovieRepository()
}