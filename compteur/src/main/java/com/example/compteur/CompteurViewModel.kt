package com.example.compteur

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompteurViewModel : ViewModel() {
    var compteur = MutableLiveData(0)

    fun plusUn() {
        compteur.value = compteur.value?.inc()
    }
}