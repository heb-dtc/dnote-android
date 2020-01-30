package com.heb.dnote.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val serverSetup: MutableLiveData<Boolean> = MutableLiveData()
    val userLogged: MutableLiveData<Boolean> = MutableLiveData()
}
