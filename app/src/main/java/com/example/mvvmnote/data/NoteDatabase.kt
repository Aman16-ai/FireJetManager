package com.example.mvvmnote.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class,Password::class],version = 2)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao():NewNoteDao
    abstract fun getPasswordDao():PasswordDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "NoteDatabase"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}