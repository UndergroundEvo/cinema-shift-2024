package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Payment (

  @SerializedName("success"   ) var success   : Boolean?             = null,
  @SerializedName("reason"    ) var reason    : String?              = null,
  @SerializedName("schedules" ) var schedules : ArrayList<Schedules> = arrayListOf()

)