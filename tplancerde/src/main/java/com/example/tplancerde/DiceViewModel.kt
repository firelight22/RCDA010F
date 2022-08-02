package com.example.tplancerde

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    var result = MutableLiveData(0)
    var sides = 6
        set(value) {
            field = value
            throwDice()
        }


    fun throwDice(){
        result.value = (1..sides).random()
    }

}