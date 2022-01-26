package com.example.mvvmnote.ui.PasswordManager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.mvvmnote.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PasswordManagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PasswordManagerFragment : Fragment() {


    private lateinit var savepassfragmentbtn:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_password_manager, container, false)
        savepassfragmentbtn = view.findViewById(R.id.save_password_screen)
        savepassfragmentbtn.setOnClickListener {
            val action = PasswordManagerFragmentDirections.actionPasswordManagerFragmentToSaveUserPassword()
            findNavController().navigate(action)
        }

        return view
    }

}