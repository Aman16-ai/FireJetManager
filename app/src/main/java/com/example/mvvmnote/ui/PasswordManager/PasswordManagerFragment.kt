package com.example.mvvmnote.ui.PasswordManager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnote.NoteAdapter
import com.example.mvvmnote.PasswordAdapter
import com.example.mvvmnote.R
import com.example.mvvmnote.data.Password
import com.example.mvvmnote.viewmodels.PasswordManagerViewModel
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
    private val passwordviewmodel: PasswordManagerViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var userPassAdapter: PasswordAdapter
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
        recyclerView = view.findViewById(R.id.pass_recyclerview)

        userPassAdapter = PasswordAdapter(requireContext())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userPassAdapter
        }

        passwordviewmodel.getUserPassword().observe(viewLifecycleOwner) {
            userPassAdapter.setPassword(it as MutableList<Password>)
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner,object:
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed(){
                val action = PasswordManagerFragmentDirections.actionPasswordManagerFragmentToHomeScreenFragment()
                view.findNavController().navigate(action)
            }

        })
        savepassfragmentbtn.setOnClickListener {
            val action = PasswordManagerFragmentDirections.actionPasswordManagerFragmentToSaveUserPassword()
            findNavController().navigate(action)
        }

        return view
    }

}