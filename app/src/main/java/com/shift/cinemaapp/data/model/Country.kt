package com.shift.cinemaapp.data.model

import com.google.gson.annotations.SerializedName


data class Country (

  @SerializedName("name"  ) var name  : String? = null,
  @SerializedName("code"  ) var code  : String? = null,
  @SerializedName("code2" ) var code2 : String? = null,
  @SerializedName("id"    ) var id    : Int?    = null

)