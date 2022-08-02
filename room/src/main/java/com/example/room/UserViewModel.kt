package com.example.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(val userDao: UserDao,application: Application)
    : AndroidViewModel(application)
{
    val user = MutableLiveData<User>()

    fun fetchOneUser(){
        viewModelScope.launch {
            userDao.getOne(1L).observeForever(Observer {
                user.postValue(it)
            })
        }
    }
}