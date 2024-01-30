package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Seance (

  @SerializedName("date" ) var date : String? = null,
  @SerializedName("time" ) var time : String? = null

)