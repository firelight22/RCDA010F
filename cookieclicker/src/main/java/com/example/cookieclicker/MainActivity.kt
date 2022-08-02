package com.example.cookieclicker

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cookieclicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var vm:CookieClickerVM
    lateinit var amb:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = DataBindingUtil.setContentView(this,R.layout.activity_main)
        vm = ViewModelProvider(this)[CookieClickerVM::class.java]
        vm.cookies.observe(this, Observer { amb.cookies = it})
        vm.cookies.observe(this, Observer { checkEnabledButtons(it)})
        vm.coefficient.observe(this, Observer {  amb.coeff = it })
        amb.imageButtonCookie.setOnClickListener(this)
        amb.buttonGrandMere.setOnClickListener(this)
        amb.buttonUsine.setOnClickListener (this)
        amb.buttonMine.setOnClickListener(this)
        amb.buttonLaboratoire.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.imageButtonCookie -> vm.addCookies()
            R.id.buttonGrandMere -> vm.buyItem(1.1f,25f)
            R.id.buttonUsine -> vm.buyItem(1.3f,100f)
            R.id.buttonMine -> vm.buyItem(1.5f,500f)
            R.id.buttonLaboratoire -> vm.buyItem(2f,1000f)
        }
    }

    fun checkEnabledButtons(cookies: Float){
        amb.buttonGrandMere.isEnabled = cookies.compareTo(25f) >= 0
        amb.buttonUsine.isEnabled = cookies.compareTo(100f) >= 0
        amb.buttonMine.isEnabled = cookies.compareTo(500f) >= 0
        amb.buttonLaboratoire.isEnabled = cookies.compareTo(1000f) >= 0
    }
}