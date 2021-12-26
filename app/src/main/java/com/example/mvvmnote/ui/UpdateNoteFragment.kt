package com.example.mvvmnote.ui

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvvmnote.R
import com.example.mvvmnote.data.Note
import com.example.mvvmnote.utils.MaterialDialogCallback
import com.example.mvvmnote.utils.MessageCallback
import com.example.mvvmnote.viewmodels.AddNoteViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.*

class UpdateNoteFragment : Fragment() {

    private lateinit var noteTitleEt:EditText
    private lateinit var noteBodyEt:EditText
    private lateinit var deleteBtn:ImageButton
    private lateinit var updateNoteBtn:ImageButton
    private val args:UpdateNoteFragmentArgs by navArgs()
    private val model:AddNoteViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update_note, container, false)
        deleteBtn = view.findViewById(R.id.delete_btn)
        noteTitleEt = view.findViewById(R.id.tv_title)
        noteBodyEt = view.findViewById(R.id.tv_body)
        updateNoteBtn = view.findViewById(R.id.update_btn)
        var noteid = args.noteobject.id
        var notebody = args.noteobject.body
        noteTitleEt.setText(args.noteobject.title)
        noteBodyEt.setText(args.noteobject.body)

        Log.d("Noteid", "onCreateView: "+noteid+" Note body "+notebody)

        updateNoteBtn.setOnClickListener {
            MessageCallback.makeMaterialDialog(requireContext(),"Attention","Update this note?","Clicked on update button","Yes","no",object:MaterialDialogCallback {
                override fun positivetask() {
                    model.updateNote(Note(id = args.noteobject.id,title = noteTitleEt.text.toString(),body = noteBodyEt.text.toString()))
                    val action = UpdateNoteFragmentDirections.actionUpdateNoteFragmentToNoteFragment()
                    it.findNavController().navigate(action)
                }

            })

        }
        deleteBtn.setOnClickListener {
            MessageCallback.makeMaterialDialog(requireContext(),"Attention","Delete this note?","Clicked on delete button","Yes","No",object:MaterialDialogCallback {
                override fun positivetask() {
                    model.deleteNote(args.noteobject)
                   val action = UpdateNoteFragmentDirections.actionUpdateNoteFragmentToNoteFragment()
                   it.findNavController().navigate(action)
                }

            })
        }
        return view
    }


}