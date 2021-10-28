package com.attrecto.academy.android.ui.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.attrecto.academy.android.FakeData
import com.attrecto.academy.android.R

class ListViewModel : ViewModel() {
    val movies = mutableStateOf(FakeData.movies)
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