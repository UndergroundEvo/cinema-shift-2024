package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Schedules (

  @SerializedName("date"    ) var date    : String?            = null,
  @SerializedName("seances" ) var seances : ArrayList<Seances> = arrayListOf()

)