package com.example.intentexpl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val intentTarget = Intent(this, TargetActivity::class.java)
        intentTarget.putExtra("identifiant", 5654)
        button.setOnClickListener {
            startActivity(intentTarget)
        }
    }
}