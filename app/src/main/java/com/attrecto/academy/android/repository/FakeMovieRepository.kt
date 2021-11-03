package com.attrecto.academy.android.repository

import com.attrecto.academy.android.model.Movie

class FakeMovieRepository : MovieRepository {
    /*
        2. Feladat
        Az előző mindig üres Repository nem nagyon tette izgalmassá az alkalmazást.

        Egészítsd ki ezt a FakeMovieRepository-t, hogy a FakeData.movies listából adja vissza
        az adatokat, de szűrve a keyword-re.

        - Jó szokás ha a movies listát külső dependency-ként kapja a FakeMovieRepository
        - A listának van contains() metódusa
     */
    override suspend fun getMovieList(keyword: String): List<Movie> {
        TODO("Not yet implemented")
    }
}