package com.example.mvvmnote.viewmodels

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.View
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.example.mvvmnote.data.CredentialsDao
import com.example.mvvmnote.ui.HomeScreenFragmentDirections
import com.example.mvvmnote.ui.PasswordManager.LoginFragmentDirections
import com.example.mvvmnote.ui.PasswordManager.SetPasswordFragment
import com.example.mvvmnote.ui.PasswordManager.SetPasswordFragmentDirections
import com.example.mvvmnote.utils.toast

class PasswordManagerViewModel(application : Application): AndroidViewModel(application) {
    private val credentialsDao = CredentialsDao(application.applicationContext)
    fun setPassword(view: View,password:String) {
        if(credentialsDao.setCredentials(password)) {
            val action = SetPasswordFragmentDirections.actionSetPasswordFragmentToPasswordManagerFragment()
            view.findNavController().navigate(action)
        }
    }
    fun loginWithPassword(view:View,password: String) {
        if(credentialsDao.loginWithCredentials(password)) {
            val action = LoginFragmentDirections.actionLoginFragmentToPasswordManagerFragment()
            view.findNavController().navigate(action)
        }else {
            getApplication<Application>().toast("Login to failed")
        }
    }
    fun passwordFragmentState(view: View) {
        credentialsDao.passwordFragmentUI(view)
    }


}