package com.shift.cinemaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shift.cinemaapp.ui.theme.CinemaAppTheme
import com.shift.cinemaapp.ui.theme.navBar
import com.shift.cinemaapp.ui.theme.topBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            CinemaAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = "screen_1"
                ){
                    composable("screen_1"){
                        navBar()
                    }
                    composable("screen_2"){
                        topBar("fas")
                    }
                }
                Surface {


                }
            }
        }
    }
}
