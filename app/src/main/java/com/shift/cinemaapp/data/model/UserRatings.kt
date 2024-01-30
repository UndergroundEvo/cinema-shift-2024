package com.shift.cinemaapp.data.model

import com.google.gson.annotations.SerializedName


data class UserRatings (

  @SerializedName("kinopoisk" ) var kinopoisk : String? = null,
  @SerializedName("imdb"      ) var imdb      : String? = null

)