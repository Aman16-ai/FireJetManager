package com.example.mvvmnote.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.mvvmnote.R
import com.example.mvvmnote.viewmodels.PasswordManagerViewModel


class HomeScreenFragment : Fragment() {
    private lateinit var noteBtn:Button
    private lateinit var passwordBtn:Button
    private val passwordManagerViewModel:PasswordManagerViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home_screen, container, false)
        noteBtn = view.findViewById(R.id.NoteManagerBtn)
        passwordBtn = view.findViewById(R.id.PasswordManagerBtn)
        noteBtn.setOnClickListener {
            var action = HomeScreenFragmentDirections.actionHomeScreenFragmentToNoteFragment()
            it.findNavController().navigate(action)
        }
        passwordBtn.setOnClickListener {
            passwordManagerViewModel.passwordFragmentState(it)
        }
        return view
    }


}