package com.example.tprandomgenerator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Je récupère mes vues mon activity_main.xml
        val editTextMin = findViewById<EditText>(R.id.editTextMin)
        val editTextMax = findViewById<EditText>(R.id.editTextMax)
        val buttonGenerate = findViewById<Button>(R.id.buttonGenerate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        //Lorsque je clic sur le bouton, je récupère le min et max
        // puis je génére un nombre aléatoire entre min et max et affiche result
        buttonGenerate.setOnClickListener {
            val minValue = editTextMin.text.toString().toIntOrNull()
            val maxValue = editTextMax.text.toString().toIntOrNull()
            if(minValue == null || maxValue == null){
                Toast.makeText(this,
                    "Ces nombres ne sont pas des Int",
                    Toast.LENGTH_SHORT).show()
            }else if(minValue > maxValue){
                Toast.makeText(this,
                    "Minimum est supérieur à Maximum",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                val result = (minValue..maxValue).random()
                textViewResult.text = result.toString()
            }

        }
    }
}