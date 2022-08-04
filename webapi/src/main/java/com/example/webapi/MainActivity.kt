package com.example.webapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import java.io.IOException

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalStdlibApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()
        val requestRandomBeer = Request.Builder()
            .url("https://api.punkapi.com/v2/beers/random")
            .build()
        client.newCall(requestRandomBeer).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                Log.i(TAG, "onResponse: $body")
                /*Désérialization manuelle
                val tabBeerJson = JSONArray(body)
                val beerJson = tabBeerJson.getJSONObject(0)

                val listFoodPairing = arrayListOf<String>()
                val jsonArrayFoodPairing = beerJson.getJSONArray("food_pairing")
                for(food in 0 until jsonArrayFoodPairing.length()){
                    listFoodPairing.add(jsonArrayFoodPairing.getString(food))
                }
//
                val beer = Beer(
                    beerJson.getInt("id"),
                    beerJson.getString("name"),
                    beerJson.getString("tagline"),
                    beerJson.getString("description"),
                    listFoodPairing
                )*/
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                val beers = moshi.adapter<List<Beer>>().fromJson(body)
                val beer= beers?.get(0)
                Log.i(TAG, "onResponse: La bière ${beer?.name} possède l'id ${beer?.id}" +
                        " et sa tagline est ${beer?.tagline}. Elle peut se combiner avec les repas : " +
                        "${beer?.foodPairing}. Voici sa description ${beer?.description}")
            }

        })
    }
}