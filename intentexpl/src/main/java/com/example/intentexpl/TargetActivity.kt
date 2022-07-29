package com.example.intentexpl

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        val id = intent.getIntExtra("identifiant", -1)
        Toast.makeText(this,
            "L'identifiant récupéré est $id",
            Toast.LENGTH_SHORT).show()
    }
}