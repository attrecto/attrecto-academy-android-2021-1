package com.attrecto.academy.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.attrecto.academy.android.model.Movie

@Composable
fun DetailScreen(imdbId: String) {
    val movie = remember {
        FakeData.movies.find {
            it.imdbId == imdbId
        }
    }

    movie?.let { MovieDetail(it) }
}

@Composable
fun MovieDetail(movie: Movie) {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .padding(8.dp)
            .verticalScroll(scrollState)
    ) {
        Row {
            Image(
                painter = rememberImagePainter(data = movie.poster),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .aspectRatio(0.65f),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = stringResource(R.string.year_label),
                    style = MaterialTheme.typography.caption
                )

                Text(
                    text = "${movie.year}",
                    style = MaterialTheme.typography.subtitle1
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.imdb_id_label),
                    style = MaterialTheme.typography.caption
                )

                Text(
                    text = movie.imdbId,
                    style = MaterialTheme.typography.subtitle1
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.imdb_rating_label),
                    style = MaterialTheme.typography.caption
                )

                Text(
                    text = "${movie.imdbRating}",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = movie.title,
            fontFamily = FontFamily.Serif,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = movie.plot,
            style = MaterialTheme.typography.subtitle1
        )
    }
}