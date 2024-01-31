package com.shift.cinemaapp.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shift.cinemaapp.R
import com.shift.cinemaapp.data.CinemaViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaApp(
    modifier: Modifier = Modifier
) {
    val cinemaViewModel: CinemaViewModel =
        viewModel(factory = CinemaViewModel.Factory)

    //пока не придумал как это отделить от navBar
        val items = listOf(
            BottomNavigationItem(
                //title = R.string.afisha.toString(),
                title = "Афиша",
                icon = ImageVector.vectorResource(R.drawable.movie),
                hasNews = false,
                badgeCount = null
            ),
            BottomNavigationItem(
                //title = R.string.tickets.toString(),
                title = "Билеты",
                icon = ImageVector.vectorResource(R.drawable.ticket),
                hasNews = false,
                badgeCount = null
            ),
            BottomNavigationItem(
                //title = R.string.profile.toString(),
                title = "Профиль",
                icon = ImageVector.vectorResource(R.drawable.profile),
                hasNews = false,
                badgeCount = null
            )
        )
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
    //временно

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index

                            //navController.navigate
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ){
                                Icon(imageVector = item.icon, contentDescription = item.title)
                            }
                        })
                }
            }
        }

    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            //color = MaterialTheme.colors.background
        ) {
            HomeScreen(
                cinemaUiState = cinemaViewModel.cinemaUiState,
                retryAction = { cinemaViewModel.getFilm() },
                modifier = modifier
            )
        }
    }
}
