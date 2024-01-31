package com.shift.cinemaapp.data.model

data class TodayModel (

  var success : Boolean,
  var films   : List<Film> = arrayListOf()

)