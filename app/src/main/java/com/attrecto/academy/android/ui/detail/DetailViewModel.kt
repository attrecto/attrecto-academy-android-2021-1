package com.attrecto.academy.android.ui.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.attrecto.academy.android.model.domain.Movie
import com.attrecto.academy.android.repository.MovieRepository
import com.attrecto.academy.android.ui.list.ListViewModel
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val repository = MovieRepository()
    val movie = mutableStateOf<Movie?>(null)
    val similarMovies = mutableStateOf<List<Movie>>(emptyList())
    val loading = mutableStateOf(false)

    fun getMovieDetails(imdbId: String) {
        viewModelScope.launch {
            loading.value = true
            movie.value = repository.getMovie(imdbId)
            similarMovies.value = repository.getMovieList(ListViewModel.KEYWORD)
                .filter { it.imdbId != imdbId }
                .shuffled()
            loading.value = false
        }
    }
}