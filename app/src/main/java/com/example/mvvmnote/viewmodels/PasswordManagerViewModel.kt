package com.example.mvvmnote.viewmodels

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.View
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.mvvmnote.data.CredentialsDao
import com.example.mvvmnote.ui.HomeScreenFragmentDirections
import com.example.mvvmnote.ui.PasswordManager.LoginFragmentDirections
import com.example.mvvmnote.ui.PasswordManager.SetPasswordFragment
import com.example.mvvmnote.ui.PasswordManager.SetPasswordFragmentDirections
import com.example.mvvmnote.utils.toast

class PasswordManagerViewModel(application : Application): AndroidViewModel(application) {
    private var setPasswordState: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var loginPasswordState : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun getSetPasswordState(): MutableLiveData<Boolean> {
        return setPasswordState
    }
    fun getLoginPasswordState() : MutableLiveData<Boolean> {
        return loginPasswordState
    }
    private val credentialsDao = CredentialsDao(application.applicationContext)
    fun setPassword(password:String) {
        setPasswordState.value = credentialsDao.setCredentials(password)
    }
    fun loginWithPassword(password: String) {
        loginPasswordState.value = credentialsDao.loginWithCredentials(password)
    }
    fun passwordFragmentState(view: View) {
        credentialsDao.passwordFragmentUI(view)
    }


}