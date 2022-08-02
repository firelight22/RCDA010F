package com.example.room

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Nous récupérons un ViewModel injecté de la UserDao
        val vm : UserViewModel = ViewModelProvider(this, ViewModelFactory(application))
            .get(UserViewModel::class.java)
        vm.user.observe(this, Observer {
            val txtView = findViewById<TextView>(R.id.textView)
            txtView.text = it.toString()
        })
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { vm.fetchOneUser()}
    }
}