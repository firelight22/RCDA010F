package com.example.tplancerde

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tplancerde.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var db : ActivityMainBinding
    lateinit var vm : DiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DataBindingUtil.setContentView(this,R.layout.activity_main)
        vm = ViewModelProvider(this)[DiceViewModel::class.java]
        db.button10.setOnClickListener(this)
        db.button8.setOnClickListener(this)
        db.button6.setOnClickListener(this)
        db.button4.setOnClickListener(this)
        db.buttonThrow.setOnClickListener(this)
        db.button12.setOnClickListener(this)
        db.button20.setOnClickListener(this)
        afficherResultat()
    }
    fun afficherResultat(){
        db.textViewResult.text = vm.result.toString()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button4 -> vm.sides = 4
            R.id.button6 -> vm.sides = 6
            R.id.button8 -> vm.sides = 8
            R.id.button10 -> vm.sides = 10
            R.id.button12 -> vm.sides = 12
            R.id.button20 -> vm.sides = 20
            R.id.buttonThrow -> {
                vm.throwDice()
                afficherResultat()
            }
        }
    }
}