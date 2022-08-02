package com.example.room

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(
                AppDatabase.getInstance(application).userDao()
                , application
            ) as T
        }
        throw IllegalArgumentException("Le viewModel n'est pas connu")
    }

}
