package com.shift.cinemaapp.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shift.cinemaapp.Film
import com.shift.cinemaapp.data.CinemaUiState

@Composable
fun MovieGridScreen(
    films: List<Film>,
    modifier: Modifier
) {
    /*LazyVerticalGrid(
        columns = GridCells.,
        contentPadding = PaddingValues(4.dp)
    )*/
    LazyColumn(
        contentPadding = PaddingValues(4.dp)
    )
    {
        itemsIndexed(films) { _, films ->
            MovieCard(movie = films, modifier)
        }
    }
}

@Composable
fun HomeScreen(
    cinemaUiState: CinemaUiState,
    retryAction: () -> Unit,
    modifier: Modifier
) {
    when (cinemaUiState) {
        is CinemaUiState.Loading -> LoadingScreen(modifier)
        is CinemaUiState.Success -> MovieGridScreen(
            films = cinemaUiState.cinemaSearch,
            modifier = modifier
        )
        is CinemaUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}