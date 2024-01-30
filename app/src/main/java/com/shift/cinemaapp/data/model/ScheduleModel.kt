package com.shift.cinemaapp.data.model

import com.google.gson.annotations.SerializedName


data class ScheduleModel (

  @SerializedName("success"   ) var success   : Boolean?             = null,
  @SerializedName("schedules" ) var schedules : ArrayList<Schedules> = arrayListOf()

)