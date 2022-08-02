package com.example.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true)
                var id:Long =0L,
                var name:String,
                var surname:String)
