package com.shift.cinemaapp.data.model

data class Film (

  val id           : String,
  val name         : String,
  val originalName : String,
  val description  : String,
  val releaseDate  : String,
  val actors       : List<Actor>,
  val directors    : List<Director>,
  val runtime      : Int,
  val ageRating    : String,
  val genres       : List<String>,
  val userRatings  : UserRatings,
  val img          : String,
  val country      : Country? = null
)