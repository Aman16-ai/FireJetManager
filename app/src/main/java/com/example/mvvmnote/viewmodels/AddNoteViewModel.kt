package com.example.mvvmnote.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.mvvmnote.data.NewNoteDao
import com.example.mvvmnote.data.Note
import com.example.mvvmnote.data.NoteDatabase
import com.example.mvvmnote.utils.MessageCallback
import com.google.android.play.core.tasks.Tasks.await
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddNoteViewModel(application: Application) : AndroidViewModel(application){
    private var dao: NewNoteDao = NoteDatabase.getDatabase(application).getNoteDao()

    fun insertNote(note: Note) {
         viewModelScope.launch {
             dao.insert(note)
             MessageCallback.makeToast(getApplication(),"Note add successfully")
         }

    }
    fun fetchAllNotes():LiveData<List<Note>> {
        return dao.fetchAllNotes()
    }

    fun updateNote(note:Note) {
        viewModelScope.launch {
            dao.updateNote(note)
            MessageCallback.makeToast(getApplication(),"Note update successfully")
        }
    }
    fun deleteNote(note:Note) {
        viewModelScope.launch {
            dao.deleteNote(note)
            MessageCallback.makeToast(getApplication(),"Note deleted successfully")
        }
    }


}
