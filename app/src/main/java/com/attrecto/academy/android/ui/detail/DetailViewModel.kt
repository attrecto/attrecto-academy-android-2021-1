package com.attrecto.academy.android.ui.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.attrecto.academy.android.FakeData
import com.attrecto.academy.android.model.Movie

class DetailViewModel : ViewModel() {
    val movie = mutableStateOf<Movie?>(null)

    fun setMovie(imdbId: String) {
        movie.value = FakeData.movies.find { it.imdbId == imdbId }
    }
}