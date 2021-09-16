package com.attrecto.academy.android.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.attrecto.academy.android.R
import com.attrecto.academy.android.model.Movie

@Composable
fun DetailScreen(
    imdbId: String,
    viewModel: DetailViewModel = viewModel()
) {
    val movie by viewModel.movie
    val similarMovies by viewModel.similarMovies

    viewModel.setMovie(imdbId)

    movie?.let { MovieDetail(it, similarMovies) }
}

@Composable
fun MovieDetail(movie: Movie, similarMovies: List<Movie>) {
    val scrollState = rememberScrollState()
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        ImageDialog(imageUrl = movie.poster) {
            showDialog.value = false
        }
    }

    Column(
        Modifier
            .verticalScroll(scrollState)
    ) {
        Row(Modifier.padding(8.dp, 8.dp, 8.dp)) {
            Image(
                painter = rememberImagePainter(data = movie.poster),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .aspectRatio(0.65f)
                    .clickable { showDialog.value = true },
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
            fontSize = 28.sp,
            modifier = Modifier.padding(8.dp, 8.dp, 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = movie.plot,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(8.dp, 8.dp, 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(similarMovies) {
                SimilarMovieCard(movie = it)
            }
        }
    }
}

@Composable
fun SimilarMovieCard(movie: Movie) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 6.dp,
        modifier = Modifier
            .size(100.dp, 140.dp)
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = rememberImagePainter(data = movie.poster),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = movie.title,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}