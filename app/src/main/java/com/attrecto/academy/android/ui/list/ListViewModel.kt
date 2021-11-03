package com.attrecto.academy.android.ui.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.attrecto.academy.android.FakeData
import com.attrecto.academy.android.R
import com.attrecto.academy.android.di.provideMovieRepository
import com.attrecto.academy.android.model.Movie
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    /*
        1. Feladat
        Jelenleg a filmeket a FakeData.movies listából szerezzük meg. Ez nem olyan gyakori éles
        projekteknél, sokkal inkább jönnek adatbázisból, vagy egy szervertől, vagy valahonnan.

        A valahonnan-t nevezzük MovieRepository-nak. Kicsit előkészítettem a kódot, van
        MovieRepository interface, és a "di" package-ben van provideMovieRepository() függvény
        ami visszaad egy osztályt ami megvalósítja

        Mi az az interface? "Szerződés"

        - Készíts egy repository példányt, használd a provideMovieRepository függvényt
        - a movies kezdeti értéke legyen üres lista
        - készíts egy init függvényt ami betölti az adatokat movies-be a repository-ból
        init {
            viewModelScope.launch {
                movies.value = repository.getMovieList("star")
            }
        }
     */
    val movies = mutableStateOf(emptyList<Movie>())
    val titleRes = mutableStateOf(R.string.app_bar_title)

    fun sort(sortBy: Sort) {
        when (sortBy) {
            Sort.BY_IMDB -> {
                movies.value = movies.value.sortedBy { it.imdbId }
                titleRes.value = R.string.sort_by_imdb_id
            }
            Sort.BY_TITLE -> {
                movies.value = movies.value.sortedBy { it.title }
                titleRes.value = R.string.sort_by_title
            }
            Sort.BY_YEAR -> {
                movies.value = movies.value.sortedBy { it.year }
                titleRes.value = R.string.sort_by_year
            }
        }
    }
}