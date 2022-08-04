package com.example.webapi

import com.squareup.moshi.Json

data class Beer(
    val id:Int,
    val name:String,
    val tagline: String,
    val description: String,
    @Json(name = "food_pairing")
    val foodPairing: List<String>
)
