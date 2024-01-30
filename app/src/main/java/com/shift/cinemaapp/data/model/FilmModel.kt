package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class FilmModel (

  @SerializedName("success" ) var success : Boolean? = null,
  @SerializedName("film"    ) var film    : Film?    = Film()

)