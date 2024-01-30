package com.shift.cinemaapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val cinemaRepository: CinemaRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://shift-backend.onrender.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: CinemaService by lazy {
        retrofit.create(CinemaService::class.java)
    }
    override val cinemaRepository: CinemaRepository by lazy {
        NetworkCinemaRepository(retrofitService)
    }
}