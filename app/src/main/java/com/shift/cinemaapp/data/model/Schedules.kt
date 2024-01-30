package com.shift.cinemaapp.data.model

import com.google.gson.annotations.SerializedName
import com.shift.cinemaapp.Seances


data class Schedules (

  @SerializedName("date"    ) var date    : String?            = null,
  @SerializedName("seances" ) var seances : ArrayList<Seances> = arrayListOf()

)