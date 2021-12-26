package com.example.mvvmnote.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvvmnote.NoteAdapter
import com.example.mvvmnote.R
import com.example.mvvmnote.data.Note
import com.example.mvvmnote.viewmodels.AddNoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NoteFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private val model:AddNoteViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_note, container, false)
        var adapter: NoteAdapter = NoteAdapter(requireActivity())

        recyclerView = view.findViewById(R.id.note_recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = adapter



        model.fetchAllNotes().observe(viewLifecycleOwner, Observer {
            for(note in it) {
                Log.d("AllNotes", "onCreateView: "+note.title)
            }
            adapter.setNotes(it as MutableList<Note>)
        })



        var addNotebtn = view.findViewById<FloatingActionButton>(R.id.add_note_fragment_btn)
        addNotebtn.setOnClickListener {
            val action = NoteFragmentDirections.actionNoteFragmentToAddNoteFragment()
            view.findNavController().navigate(action)
        }
        return view
    }


}