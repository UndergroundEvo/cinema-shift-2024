package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class TodayModel (

  @SerializedName("success" ) var success : Boolean?         = null,
  @SerializedName("films"   ) var films   : ArrayList<Film> = arrayListOf()

)