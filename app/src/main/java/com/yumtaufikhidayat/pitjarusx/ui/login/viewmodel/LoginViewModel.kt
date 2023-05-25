package com.yumtaufikhidayat.pitjarusx.ui.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yumtaufikhidayat.pitjarusx.data.NetworkResult
import com.yumtaufikhidayat.pitjarusx.data.repository.PitjarusXRepository
import com.yumtaufikhidayat.pitjarusx.model.login.LoginResponse
import com.yumtaufikhidayat.pitjarusx.model.login.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: PitjarusXRepository
) : ViewModel() {
    fun loginRemote(username: String, password: String): LiveData<NetworkResult<LoginResponse>> {
       return repository.loginRemote(username, password)
    }

    fun insertLogin(listStore: List<Store>) = viewModelScope.launch {
        repository.insertLogin(listStore)
    }
}