package com.example.mvvmnote.data

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface NewNoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:Note)
    @Query("SELECT * FROM new_note_table")
    fun fetchAllNotes(): LiveData<List<Note>>

    @Update
    suspend fun updateNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note):Int
}