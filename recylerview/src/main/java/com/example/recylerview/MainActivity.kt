package com.example.recylerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayListVelo = arrayListOf(
            Velo("VanMoof","S3",4,2348.0f,true,"https://www.vanmoof.com/sites/default/files/2021-04/D_S3Dark_1_0.jpg"),
            Velo("Amsterdam Air","1881 Premium",1,1829f,true,"https://www.amsterdamair.fr/93051/velo-electrique-amsterdam-air-1881-exclusive-finition-bord-de-mer.jpg"),
            Velo("Decathlon","OkTier",8,250.0f,false,"https://www.vanmoof.com/sites/default/files/2021-04/D_S3Dark_1_0.jpg"),
            Velo("Peugeot Cycle","PeugeotBike",8,120.0f,false,"https://www.vanmoof.com/sites/default/files/2021-04/D_S3Dark_1_0.jpg"),
            Velo("Angell","Angell",4,2900.0f,true,"https://www.vanmoof.com/sites/default/files/2021-04/D_S3Dark_1_0.jpg"),
        )
        val adapter = VeloAdapter(arrayListVelo, VeloAdapter.OnVeloClickListener {
            Toast.makeText(this,
                "Le vélo clické est $it", Toast.LENGTH_SHORT).show()
        })
        val rv = findViewById<RecyclerView>(R.id.recyclerViewVelo)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }
}