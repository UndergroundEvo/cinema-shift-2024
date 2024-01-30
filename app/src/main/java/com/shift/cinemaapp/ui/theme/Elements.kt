package com.shift.cinemaapp.ui.theme

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean
)


//@Composable
//fun navBar(){
//    Scaffold(NavigationBar {
//
//        }
//    ) {
//
//    }
//}