package com.example.mvvmnote.data

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.view.View
import androidx.core.content.edit
import androidx.navigation.findNavController
import com.example.mvvmnote.ui.HomeScreenFragmentDirections
import com.example.mvvmnote.utils.MessageCallback
import com.example.mvvmnote.utils.toast

class CredentialsDao(var context: Context) {
    private val credentialssharedPreferences = context.getSharedPreferences("credentials", MODE_PRIVATE)

    fun loginWithCredentials(password: String): Boolean {
        return password.isNotEmpty() && credentialssharedPreferences.getString("password","default").equals(password)
    }


    fun setCredentials(password:String):Boolean {

        return if(password.isNotEmpty()) {
            credentialssharedPreferences.edit {
                putString("password",password.trim())
            }
            true
        } else {
            false
        }
    }
    fun passwordFragmentUI(view: View) {
        val sharedPreferences = context.getSharedPreferences("setPasswordState", MODE_PRIVATE)
        if (sharedPreferences.getString("isDone", "default").equals("yes") && (!credentialssharedPreferences.getString("password","default").equals("default"))) {
            val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToLoginFragment()
            view.findNavController().navigate(action)
        } else {
            val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToSetPasswordFragment()
            view.findNavController().navigate(action)

            sharedPreferences.edit {
                this.putString("isDone", "yes")
            }
        }
    }
}