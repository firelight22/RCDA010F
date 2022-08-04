package com.example.tprecyclerviewdog

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val name:String,
    val breed: String,
    val color: String,
    val age: Int,
    val imageUrl: String,
) : Parcelable
