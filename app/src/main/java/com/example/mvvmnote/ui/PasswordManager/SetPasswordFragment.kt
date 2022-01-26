package com.example.mvvmnote.ui.PasswordManager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.findNavController
import com.example.mvvmnote.R
import com.example.mvvmnote.viewmodels.PasswordManagerViewModel
import com.google.android.material.textfield.TextInputEditText


class SetPasswordFragment : Fragment() {
    private lateinit var passwordet:TextInputEditText
    private lateinit var btn: Button
    private val passwordManagerViewModel : PasswordManagerViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_set_password, container, false)
        passwordet = view.findViewById(R.id.set_pass_textInputEt)
        btn = view.findViewById(R.id.save_credentials_btn)
        passwordManagerViewModel.getSetPasswordState().observe(viewLifecycleOwner) {
            if (it) {
                val action = SetPasswordFragmentDirections.actionSetPasswordFragmentToPasswordManagerFragment()
                view.findNavController().navigate(action)
            }

        }
        btn.setOnClickListener {
            passwordManagerViewModel.setPassword(passwordet.text.toString())
        }
        return view
    }

}