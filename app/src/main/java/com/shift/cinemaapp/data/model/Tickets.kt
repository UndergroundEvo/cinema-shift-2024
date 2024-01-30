package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Tickets (

  @SerializedName("filmId" ) var filmId : String? = null,
  @SerializedName("row"    ) var row    : Int?    = null,
  @SerializedName("column" ) var column : Int?    = null,
  @SerializedName("seance" ) var seance : Seance? = Seance(),
  @SerializedName("phone"  ) var phone  : String? = null

)