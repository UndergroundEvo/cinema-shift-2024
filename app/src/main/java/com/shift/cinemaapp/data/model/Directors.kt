package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Directors (

  @SerializedName("id"          ) var id          : String?           = null,
  @SerializedName("professions" ) var professions : ArrayList<String> = arrayListOf(),
  @SerializedName("fullName"    ) var fullName    : String?           = null

)