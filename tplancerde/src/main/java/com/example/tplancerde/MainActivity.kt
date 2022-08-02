package com.example.tplancerde

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tplancerde.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var db : ActivityMainBinding
    lateinit var vm : DiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DataBindingUtil.setContentView(this,R.layout.activity_main)
        vm = ViewModelProvider(this)[DiceViewModel::class.java]
        vm.result.observe(this, Observer { afficherResultat() })
        db.button4.setOnClickListener(this)
        db.button6.setOnClickListener(this)
        db.button8.setOnClickListener(this)
        db.button10.setOnClickListener(this)
        db.button12.setOnClickListener(this)
        db.button20.setOnClickListener(this)
        db.buttonThrow.setOnClickListener{
            vm.throwDice()
        }
    }
    fun afficherResultat(){
        db.textViewResult.text = vm.result.value.toString()
    }

    override fun onClick(p0: View?) {
        if(p0 is Button)
            vm.sides = p0.text.toString().toInt()
    }
}