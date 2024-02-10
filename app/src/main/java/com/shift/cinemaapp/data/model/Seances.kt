package com.shift.cinemaapp.data.model

data class Seances (

    var time         : String,
    var hall         : Hall,
    var payedTickets : List<String>

)