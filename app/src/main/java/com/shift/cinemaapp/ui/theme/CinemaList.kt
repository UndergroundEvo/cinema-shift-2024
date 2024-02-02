package com.shift.cinemaapp.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shift.cinemaapp.data.CinemaUiState
import com.shift.cinemaapp.data.model.Film

@Composable
fun MovieGridScreen(
    films: List<Film>,
    modifier: Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(4.dp)
    )
    {
        itemsIndexed(films) { _, films ->
            MovieCard(films, modifier/*, navControl*/)
        }
    }
}

@Composable
fun HomeScreen(
    cinemaUiState: CinemaUiState,
    retryAction: () -> Unit,
    modifier: Modifier,
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
