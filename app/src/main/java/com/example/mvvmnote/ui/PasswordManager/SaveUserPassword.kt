package com.example.mvvmnote.ui.PasswordManager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.mvvmnote.R
import com.example.mvvmnote.data.Password
import com.example.mvvmnote.viewmodels.PasswordManagerViewModel
import kotlin.random.Random


class SaveUserPassword : Fragment() {

    private val passwordManagerViewModel:PasswordManagerViewModel by viewModels()
    private lateinit var et_title:EditText
    private lateinit var et_length:EditText
    private lateinit var generateBtn: Button
    private lateinit var savepassBtn:Button
    private lateinit var generatedPassTv:TextView
    var password:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_save_user_password, container, false)
        et_title = view.findViewById<EditText>(R.id.et_pass_title)
        et_length = view.findViewById<EditText>(R.id.et_pass_len)
        generateBtn = view.findViewById<Button>(R.id.btn_gen_pass)
        savepassBtn = view.findViewById<Button>(R.id.btn_save_pass)
        generatedPassTv = view.findViewById<TextView>(R.id.tv_passgen)
        generateBtn.setOnClickListener {
            generatePassword(Integer.parseInt(et_length.text.toString()))
        }
        savepassBtn.setOnClickListener {
            passwordManagerViewModel.saveUserPassword(Password(name = et_title.text.toString(), password = this.password))
            val action = SaveUserPasswordDirections.actionSaveUserPasswordToPasswordManagerFragment()
            it.findNavController().navigate(action)
        }
        return view
    }
    fun generatePassword(length:Int) {
        val allchars :String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#\$%^&*()"
        for(i in 0 until length) {
            password += allchars[Random.nextInt(72)]
        }
        generatedPassTv.text = "Password : " + password
    }
}