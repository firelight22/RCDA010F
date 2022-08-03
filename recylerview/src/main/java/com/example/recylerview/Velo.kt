package com.example.recylerview

//fun Float.showCurrency() : String{return "$this €"}
data class Velo(val marque:String,
                val modele: String,
                val vitesse: Int,
                val prix:Float,
                val vae: Boolean,
                val imageUrl :String){

    fun showPrice():String{
        return "$prix €"
    }
}
