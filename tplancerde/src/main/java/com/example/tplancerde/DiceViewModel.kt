package com.example.tplancerde

import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    var result = 0
    var sides = 6

    fun throwDice(){
        result = (1..sides).random()
    }

}