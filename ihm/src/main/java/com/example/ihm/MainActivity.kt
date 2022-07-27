package com.example.ihm

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewHW = findViewById<TextView>(R.id.textViewHelloWorld)
        textViewHW.text = "HELLO JE SUIS KOTLIN!"
        textViewHW.textSize = 36.0f
        textViewHW.gravity =Gravity.CENTER

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, "BONJOUR :D", Toast.LENGTH_SHORT).show()
        }

        //Pour récupérer le contenu d'un EditText
        //mset.text.toString()
        //Pour générer un random entre 121 et 1856
        //(121..1856).random()
    }


}