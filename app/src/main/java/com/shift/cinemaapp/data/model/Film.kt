package com.shift.cinemaapp

import com.google.gson.annotations.SerializedName


data class Film (

  @SerializedName("id"           ) var id           : String?              = null,
  @SerializedName("name"         ) var name         : String?              = null,
  @SerializedName("originalName" ) var originalName : String?              = null,
  @SerializedName("description"  ) var description  : String?              = null,
  @SerializedName("releaseDate"  ) var releaseDate  : String?              = null,
  @SerializedName("actors"       ) var actors       : ArrayList<Actors>    = arrayListOf(),
  @SerializedName("directors"    ) var directors    : ArrayList<Directors> = arrayListOf(),
  @SerializedName("runtime"      ) var runtime      : Int?                 = null,
  @SerializedName("ageRating"    ) var ageRating    : String?              = null,
  @SerializedName("genres"       ) var genres       : ArrayList<String>    = arrayListOf(),
  @SerializedName("userRatings"  ) var userRatings  : UserRatings?         = UserRatings(),
  @SerializedName("img"          ) var img          : String?              = null

)