package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Places (

  @SerializedName("price" ) var price : Int?    = null,
  @SerializedName("type"  ) var type  : String? = null

)