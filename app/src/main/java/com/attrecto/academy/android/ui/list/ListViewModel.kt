package com.attrecto.academy.android.ui.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.attrecto.academy.android.R
import com.attrecto.academy.android.model.domain.Movie
import com.attrecto.academy.android.repository.MovieRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    companion object {
        const val KEYWORD = "star wars"
    }

    private val repository = MovieRepository()
    val movies = mutableStateOf<List<Movie>>(emptyList())
    val titleRes = mutableStateOf(R.string.app_bar_title)
    val loading = mutableStateOf(false)

    fun sort(sortBy: Sort) {
        when (sortBy) {
            Sort.BY_TITLE -> {
                movies.value = movies.value.sortedBy { it.title }
                titleRes.value = R.string.sort_by_title
            }
            Sort.BY_YEAR -> {
                movies.value = movies.value.sortedBy { it.year }
                titleRes.value = R.string.sort_by_year
            }
            Sort.BY_IMDB -> {
                movies.value = movies.value.sortedBy { it.imdbId }
                titleRes.value = R.string.sort_by_imdb_id
            }
        }
    }

    init {
        viewModelScope.launch {
            loading.value = true
            movies.value = repository.getMovieList(KEYWORD)
            loading.value = false
        }
    }
}