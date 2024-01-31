package com.shift.cinemaapp.data

import com.shift.cinemaapp.data.model.Film
import com.shift.cinemaapp.data.model.Schedules

interface CinemaRepository {
    suspend fun getToday() : List<Film>
//    suspend fun getFilm(filmId : Int) : List<Film>
/*    suspend fun getSchedules(filmId : Int) : List<Schedules>*/
}

class NetworkCinemaRepository(
    private val cinemaService: CinemaService
) : CinemaRepository {
    override suspend fun getToday()
    : List<Film> = cinemaService.getToday().films.map { films ->
        Film(
            id = films.id,
            name = films.name,
            originalName = films.originalName,
            description = films.description,
            releaseDate = films.releaseDate,
            actors = films.actors,
            directors = films.directors,
            runtime = films.runtime,
            ageRating = films.ageRating,
            genres = films.genres,
            userRatings = films.userRatings,
            img = films.img,
            country = films.country
        )
    }
/*    override suspend fun getFilm(filmId : Int)
    : List<Film> = cinemaService.getFilm(filmId).film. { film ->
        Film(
            id = film.id,
            name = film.name,
            originalName = film.originalName,
            description = film.description,
            releaseDate = film.releaseDate,
            actors = film.actors,
            directors = film.directors,
            runtime = film.runtime,
            ageRating = film.ageRating,
            genres = film.genres,
            userRatings = film.userRatings,
            img = film.img
        )
    }*/

/*    override suspend fun getSchedules(filmId: Int)
            : List<Schedules> = cinemaService.getSchedules(filmId).schedules.map { schedules ->
        Schedules(
        )
    }*/
}