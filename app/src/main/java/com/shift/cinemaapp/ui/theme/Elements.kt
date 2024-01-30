package com.shift.cinemaapp.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.shift.cinemaapp.R

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
fun navBar() {
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
    Scaffold(
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
    ) {}
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
//@Preview
fun topBar(title: String){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title) }
            )
        }
    )
    {}
}
