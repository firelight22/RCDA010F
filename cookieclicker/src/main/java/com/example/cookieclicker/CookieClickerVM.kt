package com.example.cookieclicker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CookieClickerVM: ViewModel() {

    var cookies = MutableLiveData(1.0f)
    var coefficient = MutableLiveData(1.00f)

    fun addCookies(){
        // cookies = coefficient + cookies
        //if(coefficient.value != null && cookies.value != null){
        //    cookies.value =coefficient.value!! + cookies.value!!
        //}
        cookies.value = coefficient.value?.let { cookies.value?.plus(it) }
    }

    /**
     * Buy the item or deny if not enough cookies
     * return true if you can buy or false if not enough cookies
     */
    fun buyItem(coefficientItem:Float, prix:Float) : Boolean {
        if(cookies.value!! < prix)
            return false
        coefficient.value = coefficient.value?.plus(coefficientItem)
        cookies.value = cookies.value?.minus(prix)
        return true
    }
}