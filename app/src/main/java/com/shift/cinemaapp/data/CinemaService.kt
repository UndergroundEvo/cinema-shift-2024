package com.shift.cinemaapp.data

import com.shift.cinemaapp.data.model.TodayModel
import retrofit2.http.GET

interface CinemaService {
    @GET("cinema/today")
    suspend fun getToday(): TodayModel

//    @GET("cinema/film")
//    suspend fun getFilm(
//        @Query("") filmId : Int
//    ): FilmModel

/*    @GET("cinema/film/{filmId}/schedule")
    suspend fun getSchedules(
        @Path("filmId") filmId : String
    ): ScheduleModel*/
}