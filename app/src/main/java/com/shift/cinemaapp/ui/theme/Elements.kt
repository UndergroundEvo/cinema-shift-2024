package com.shift.cinemaapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shift.cinemaapp.R
import com.shift.cinemaapp.data.model.Film

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.no_internet))
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.again))
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Loading")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(
    movie: Film,
    modifier: Modifier,
) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        //elevation = 8.dp
    ) {
        Row {
            Column {
                MovieImage(modifier, movie)
                movie.name.let {
                    Text(
                        text = it,
                        fontSize = 5.em,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(top = 4.dp, start = 13.dp)
                    )
                }
                movie.originalName.let {
                    Text(
                        text = it,
                        fontSize = 3.em,
                        fontStyle = FontStyle.Italic,
                        //fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(top = 4.dp, bottom = 8.dp, start = 13.dp),
                    )
                }
                movie.userRatings.imdb.toString().let {
                    Text(
                        text = "IMDb: " + it + "/10",
                        fontSize = 3.em,
                        fontStyle = FontStyle.Italic,
                        //fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(top = 4.dp, bottom = 4.dp, start = 13.dp),
                    )
                }
                movie.userRatings.kinopoisk.toString().let {
                    Text(
                        text = stringResource(id = R.string.kinopoisk) + ": " + it + "/10",
                        fontSize = 3.em,
                        fontStyle = FontStyle.Italic,
                        //fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(top = 1.dp, bottom = 8.dp, start = 13.dp),
                    )
                }
                Button(
                    onClick = {
                        isSheetOpen = true
                              },
                    modifier = modifier
                        .padding(12.dp),
                    ) {
                    Text(text = stringResource(id = R.string.more))
                }
            }
        }
    }
    if (isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Column(
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ){
                Row(modifier = Modifier.fillMaxWidth()) {
                    movie.name.let {
                        Text(
                            text = it,
                            fontSize = 5.em,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .padding(top = 4.dp, start = 13.dp)
                                .weight(3f)
                        )
                    }
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        ),
                        modifier = Modifier.padding(end = 13.dp),
                    ) {
                        movie.ageRating.let {
                            Text(
                                text = it,
                                fontSize = 6.em,
                                fontWeight = FontWeight.Black,
                                color = Color.White,
                                modifier = modifier
                                    .padding(start = 17.dp, end = 17.dp, top = 7.dp, bottom = 7.dp)

                            )
                        }
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                ) {
                    movie.releaseDate.let {
                        Text(
                            text = it,
                            fontSize = 3.em,
                            fontWeight = FontWeight.Light,
                            modifier = modifier
                                .padding(top = 2.dp, start = 13.dp)
                                .weight(2f)
                        )
                    }
                    movie.country?.name?.let {
                        Text(
                            text = it,
                            fontSize = 3.em,
                            //TextAlign = TextAlign.Right,
                            fontWeight = FontWeight.Bold,
                            //fontWeight = FontWeight.,
                            modifier = modifier
                                .padding(top = 2.dp, end = 16.dp)
                        )
                    }
                }
                OutlinedCard(modifier = modifier .padding(15.dp)) {
                    movie.description.let {
                        Text(
                            text = it,
                            fontSize = 3.em,
                            //fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .padding(13.dp)
                                .align(Alignment.Start)
                        )
                    }
                }
                Row(modifier = modifier .padding(start = 13.dp)) {
                    movie.genres.forEach{
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            modifier = Modifier.padding(end = 4.dp)
                        ) {
                            Text(
                                text = it,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    }
                }
                //поправить для филиппа
                Box(modifier = Modifier.padding(start = 13.dp, top = 7.dp)
                    .wrapContentSize()){
                    movie.directors.forEach {
                    Text(
                        text = stringResource(R.string.director)+": "+it.fullName.toString(),
                        fontSize = 3.em,
                        //fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(start = 4.dp)
                        )
                    }
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp)
                ) {
                    Text(
                        text = stringResource(R.string.schedule),
                        fontSize = 3.em,
                    )
                }
//                Row(modifier = modifier
//                    .padding(start = 13.dp)
//                    .wrapContentSize(),
//                ) {
//                    Text(text = stringResource(R.string.actor)+": ")
//                    movie.actors.forEach {
//                        Text(
//                            text = it.fullName + "\n ",
//                            fontSize = 3.em,
//                            //fontWeight = FontWeight.Bold,
//                            modifier = modifier
//                        )
//                    }
//                }

            }
        }
    }
}

@Composable
private fun MovieImage(
    modifier: Modifier,
    movie: Film
) {
    AsyncImage(
        alignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(percent = 3)),
        model = ImageRequest.Builder(context = LocalContext.current)
            //надо будет это поправить
            .data("https://shift-backend.onrender.com" + movie.img)
            .crossfade(true)
            .build(),
        error = painterResource(id = R.drawable.baseline_error_outline_24),
        placeholder = painterResource(id = R.drawable.baseline_history_toggle_off_24),
        contentDescription = stringResource(id = R.string.app_name),
        contentScale = ContentScale.Crop
    )
}

