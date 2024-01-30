package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Seances (

  @SerializedName("time"         ) var time         : String?                 = null,
  @SerializedName("hall"         ) var hall         : Hall?                   = Hall(),
  @SerializedName("payedTickets" ) var payedTickets : ArrayList<PayedTickets> = arrayListOf()

)