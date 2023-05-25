package com.yumtaufikhidayat.pitjarusx.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yumtaufikhidayat.pitjarusx.data.repository.PitjarusXRepository
import com.yumtaufikhidayat.pitjarusx.model.local.LoginLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: PitjarusXRepository
) : ViewModel() {
    fun loginRemote(username: String, password: String) = repository.loginRemote(username, password)

    fun insertLogin(loginLocal: LoginLocal) = viewModelScope.launch {
        repository.insertLogin(loginLocal)
    }
}