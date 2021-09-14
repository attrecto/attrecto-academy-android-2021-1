package com.attrecto.academy.android.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.attrecto.academy.android.FakeData
import com.attrecto.academy.android.model.Movie
import com.attrecto.academy.android.ui.main.Screen
import com.attrecto.academy.android.ui.theme.AttrectoAcademyAndroidTheme

@Composable
fun ListScreen(navController: NavController) {
    MovieList(FakeData.movies) {
        navController.navigate(Screen.Detail.route(it))
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
                    text = movie.imdbId,
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