package com.example.mvvmnote.ui.PasswordManager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mvvmnote.R
import com.example.mvvmnote.viewmodels.PasswordManagerViewModel
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {

    private lateinit var passwordet:TextInputEditText
    private lateinit var btn: Button
    private val passwordManagerViewModel:PasswordManagerViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_login, container, false)
        passwordet = view.findViewById(R.id.login_pass_textInputEt)
        btn = view.findViewById(R.id.login_btn)
        passwordManagerViewModel.getLoginPasswordState().observe(viewLifecycleOwner) {
            if(it) {
                val action = LoginFragmentDirections.actionLoginFragmentToPasswordManagerFragment()
                view.findNavController().navigate(action)
            }
        }
        btn.setOnClickListener {
            passwordManagerViewModel.loginWithPassword(passwordet.text.toString())
        }
        return view
    }


}