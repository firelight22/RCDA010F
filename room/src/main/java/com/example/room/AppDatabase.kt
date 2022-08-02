package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase? = null
        fun getInstance(ctx: Context) : AppDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        ctx,AppDatabase::class.java,"dbApp"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance;
            }

        }
    }
}