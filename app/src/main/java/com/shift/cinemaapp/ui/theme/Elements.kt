package com.shift.cinemaapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shift.cinemaapp.data.model.Film
import com.shift.cinemaapp.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
//@Preview
fun topBar(title: String) {
    TopAppBar(
        title = { Text(text = title) }
    )
}

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

@Composable
fun MovieCard(
    movie: Film,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth(),
            //.requiredHeight(300.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        //border = BorderStroke(1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
        //elevation = 8.dp
    ) {
        Row {
            Column() {
                AsyncImage(
                    alignment = Alignment.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(percent = 3)),
                    model = ImageRequest.Builder(context = LocalContext.current)
                        //надо будет это поправить
                        .data("https://shift-backend.onrender.com"+movie.img)
                        .crossfade(true)
                        .build(),
                    error = painterResource(id = R.drawable.baseline_error_outline_24),
                    placeholder = painterResource(id = R.drawable.baseline_history_toggle_off_24),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Crop
                )
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
                    onClick = { /*TODO*/ },
                    modifier = modifier
                        .padding(12.dp),
                    ) {
                    Text(text = stringResource(id = R.string.more))
                }
            }
        }

    }
}