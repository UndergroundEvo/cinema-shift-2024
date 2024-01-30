package com.shift.cinemaapp.data.model

import com.google.gson.annotations.SerializedName


data class Today (

  @SerializedName("success" ) var success : Boolean?         = null,
  @SerializedName("reason"  ) var reason  : String?          = null,
  @SerializedName("films"   ) var films   : ArrayList<Film> = arrayListOf()

)