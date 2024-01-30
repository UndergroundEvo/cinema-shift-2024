package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Hall (

  @SerializedName("name"   ) var name   : String?           = null,
  @SerializedName("places" ) var places : ArrayList<String> = arrayListOf()

)