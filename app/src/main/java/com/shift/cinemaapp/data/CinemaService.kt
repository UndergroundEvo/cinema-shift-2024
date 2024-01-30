package com.shift.cinemaapp.data

import com.shift.cinemaapp.Film
import com.shift.cinemaapp.FilmModel
import com.shift.cinemaapp.data.model.ScheduleModel
import com.shift.cinemaapp.TodayModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CinemaService {
    @GET("cinema/today")
    suspend fun getToday(): TodayModel

//    @GET("cinema/film")
//    suspend fun getFilm(
//        @Query("") filmId : Int
//    ): FilmModel

    @GET("cinema/film/{filmId}/schedule")
    suspend fun getSchedules(
        @Path("filmId") filmId : Int
    ): ScheduleModel
}