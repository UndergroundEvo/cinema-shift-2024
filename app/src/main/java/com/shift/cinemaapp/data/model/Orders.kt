package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Orders (

  @SerializedName("filmName"    ) var filmName    : String?            = null,
  @SerializedName("orderNumber" ) var orderNumber : Int?               = null,
  @SerializedName("tickets"     ) var tickets     : ArrayList<Tickets> = arrayListOf(),
  @SerializedName("phone"       ) var phone       : String?            = null,
  @SerializedName("status"      ) var status      : String?            = null

)