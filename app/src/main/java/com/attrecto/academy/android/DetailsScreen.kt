package com.attrecto.academy.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Preview
@Composable
fun DetailsScreen(id: String? = "tt0076759") {

    val movie = FakeData.movies.find { it.imdbId == id } ?: Movie("", 0, "", 0f, "", "")

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = rememberImagePainter(data = movie.poster),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(.5f)
                .aspectRatio(9f / 16f)
        )

        Spacer(modifier = Modifier.width(4.dp))

        Column {
            Text(text = stringResource(R.string.title_label))

            Text(
                text = movie.title,
                style = MaterialTheme.typography.h5
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = stringResource(R.string.year_label))

            Text(
                text = "${movie.year}",
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = stringResource(R.string.id_label))

            Text(
                text = movie.imdbId,
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = stringResource(R.string.rating_label))

            Text(text = movie.imdbRating.toString())
        }
    }
}