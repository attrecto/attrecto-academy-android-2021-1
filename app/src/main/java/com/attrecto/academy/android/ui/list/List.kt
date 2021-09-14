package com.attrecto.academy.android.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.attrecto.academy.android.FakeData
import com.attrecto.academy.android.R
import com.attrecto.academy.android.model.Movie
import com.attrecto.academy.android.ui.main.Screen
import com.attrecto.academy.android.ui.theme.AttrectoAcademyAndroidTheme

@Composable
fun ListScreen(navController: NavController) {
    val expanded = remember {
        mutableStateOf(false)
    }

    val movies = remember {
        mutableStateOf(FakeData.movies)
    }

    val titleRes = remember {
        mutableStateOf(R.string.app_bar_title)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = titleRes.value))
                },
                actions = {
                    Box(
                        Modifier.wrapContentSize(Alignment.TopEnd)
                    ) {
                        IconButton(onClick = {
                            expanded.value = true
                        }) {
                            Icon(
                                Icons.Filled.MoreVert,
                                contentDescription = null
                            )
                        }
                        DropdownMenu(
                            expanded = expanded.value,
                            onDismissRequest = { expanded.value = false }
                        ) {
                            DropdownMenuItem(onClick = {
                                expanded.value = false
                                titleRes.value = R.string.sort_by_title
                                movies.value = movies.value.sortedBy { it.title }
                            }) {
                                Text(text = stringResource(R.string.sort_by_title))
                            }

                            Divider()

                            DropdownMenuItem(onClick = {
                                expanded.value = false
                                titleRes.value = R.string.sort_by_year
                                movies.value = movies.value.sortedBy { it.year }
                            }) {
                                Text(text = stringResource(R.string.sort_by_year))
                            }

                            Divider()

                            DropdownMenuItem(onClick = {
                                expanded.value = false
                                titleRes.value = R.string.sort_by_imdb_rating
                                movies.value = movies.value.sortedBy { it.imdbRating }.reversed()
                            }) {
                                Text(text = stringResource(R.string.sort_by_imdb_rating))
                            }
                        }
                    }
                }
            )
        }
    ) {
        MovieList(movies.value) {
            navController.navigate(Screen.Detail.route(it))
        }
    }
}

@Composable
fun MovieCard(movie: Movie, onMovieClick: (imdbId: String) -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onMovieClick(movie.imdbId)
            }
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = rememberImagePainter(data = movie.poster),
                contentDescription = null,
                modifier = Modifier.size(90.dp, 120.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Column {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h5
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${movie.year}",
                    style = MaterialTheme.typography.subtitle1
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${movie.imdbRating}",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@Composable
fun MovieList(movies: List<Movie>, onMovieClick: (imdbId: String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(movies) {
            MovieCard(movie = it, onMovieClick)
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieCardPreview() {
    AttrectoAcademyAndroidTheme {
        MovieCard(FakeData.movies[0]) {}
    }
}