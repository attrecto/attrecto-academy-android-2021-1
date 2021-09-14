package com.attrecto.academy.android

import android.content.res.Configuration
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.attrecto.academy.android.ui.theme.AttrectoAcademyAndroidTheme

@Composable
fun ListScreen() {
    MovieList(FakeData.movies)
}

@Composable
fun MovieCard(movie: Movie) {
    val context = LocalContext.current

    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "Click", Toast.LENGTH_SHORT)
                    .show()
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
fun MovieList(movies: List<Movie>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(movies) {
            MovieCard(movie = it)
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieCardPreview() {
    AttrectoAcademyAndroidTheme {
        MovieCard(FakeData.movies[0])
    }
}