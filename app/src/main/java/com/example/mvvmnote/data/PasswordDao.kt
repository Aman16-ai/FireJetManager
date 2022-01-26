package com.example.mvvmnote.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PasswordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPassword(password: Password)
    @Query("SELECT * FROM password_table")
    fun fetchAllPasswords():LiveData<List<Password>>

}