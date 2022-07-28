package com.example.safeargs

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(val nom:String ="Doe",
                val prenom:String = "John") : Parcelable
