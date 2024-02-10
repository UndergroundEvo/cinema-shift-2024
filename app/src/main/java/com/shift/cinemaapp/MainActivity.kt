package com.shift.cinemaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.shift.cinemaapp.ui.theme.CinemaApp
import com.shift.cinemaapp.ui.theme.CinemaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val navController = rememberNavController()
            CinemaAppTheme {
                CinemaApp()
            }
        }
    }
}


