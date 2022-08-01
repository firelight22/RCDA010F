package com.example.compteur

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.compteur.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //var compteur = 0
    lateinit var textViewCompteur : TextView
    lateinit var buttonCompteur : Button
    lateinit  var vm : CompteurViewModel //()
    lateinit var db : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //Affectation des variables avec les vues
        textViewCompteur = findViewById(R.id.textViewCompteur)
        buttonCompteur = findViewById(R.id.buttonCompteur)
        vm = ViewModelProvider(this).get(CompteurViewModel::class.java)
        vm.compteur.observe(this, Observer { afficherCompteur() })
        buttonCompteur.setOnClickListener { onClickCompteur() }
    }

    fun onClickCompteur(){
        //compteur++
        vm.plusUn()
    }

    private fun afficherCompteur() {
        db.vm = vm
    }

    //override fun onSaveInstanceState(outState: Bundle) {
    //    outState.putInt("compteur", compteur)
    //    super.onSaveInstanceState(outState)
    //}

    //override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    //    super.onRestoreInstanceState(savedInstanceState)
    //    compteur = savedInstanceState.getInt("compteur")
    //    afficherCompteur()
    //}
}