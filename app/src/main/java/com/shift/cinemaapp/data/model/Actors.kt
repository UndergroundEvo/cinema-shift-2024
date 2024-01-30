package com.shift.cinemaapp.data.model

import com.google.gson.annotations.SerializedName


data class Actors (

  @SerializedName("id"          ) var id          : String? = null,
  @SerializedName("professions" ) var professions : String? = null,
  @SerializedName("fullName"    ) var fullName    : String? = null

)