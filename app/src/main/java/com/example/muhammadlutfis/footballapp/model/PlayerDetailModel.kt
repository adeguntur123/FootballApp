package com.example.muhammadlutfis.footballapp.model

import com.google.gson.annotations.SerializedName

data class PlayerDetailModel (
    @SerializedName("idPlayer")
    var idPlayer: String? = null,

    @SerializedName("strWeight")
    var strWeight: String? = null,

    @SerializedName("strHeight")
    var strHeight: String? = null,

    @SerializedName("strPlayer")
    var strPlayer: String? = null,

    @SerializedName("strFanart1")
    var strFanart1: String? = null,

    @SerializedName("strPosition")
    var strPosition: String? = null,

    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String? = null
)