package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM User")
    fun get() : LiveData<List<User>>

    @Query("SELECT * FROM User WHERE id = :id")
    fun getOne(id: Long) : LiveData<User>

    @Update
    fun update(user: User)

    @Delete
    fun delete(user:User)

}