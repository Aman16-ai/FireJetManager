package com.example.mvvmnote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnote.data.Note
import com.example.mvvmnote.ui.NoteFragmentDirections

class NoteAdapter(var context: Context) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private  var notes:MutableList<Note> = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var noteTitleTextView: TextView = itemView.findViewById<TextView>(R.id.title_list_tv)
        var noteBodyTextView :TextView = itemView.findViewById(R.id.sub_title_list_tv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.note_list,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.noteTitleTextView.text = notes[position].title
        holder.noteBodyTextView.text = notes[position].body
        holder.itemView.setOnClickListener{
            val note = notes[position]
            val action = NoteFragmentDirections.actionNoteFragmentToUpdateNoteFragment(note)
            it.findNavController().navigate(action)
        }
    }

    fun setNotes(notes:MutableList<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()

    }
    override fun getItemCount(): Int {
        return notes.size
    }
}


