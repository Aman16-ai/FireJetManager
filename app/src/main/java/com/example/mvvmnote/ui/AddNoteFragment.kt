package com.example.mvvmnote.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.mvvmnote.R
import com.example.mvvmnote.data.Note
import com.example.mvvmnote.viewmodels.AddNoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddNoteFragment : Fragment() {

    private val model: AddNoteViewModel by activityViewModels()
    private lateinit var notetitleet: EditText
    private lateinit var notebodyet: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_add_note, container, false)
        val saveBtn = view.findViewById<FloatingActionButton>(R.id.save_note_btn)
        notetitleet = view.findViewById(R.id.note_title_et)
        notebodyet = view.findViewById(R.id.note_body_et)

        saveBtn.setOnClickListener {
            var title:String = notetitleet.text.toString()
            var body:String = notebodyet.text.toString()
            model.insertNote(Note(title = title,body = body))
            var action = AddNoteFragmentDirections.actionAddNoteFragmentToNoteFragment()
            view.findNavController().navigate(action)
        }
        return view
    }


}