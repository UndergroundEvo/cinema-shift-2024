package com.shift.cinemaapp.data

import android.app.Application

class CinemaApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}