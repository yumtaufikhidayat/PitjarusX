package com.yumtaufikhidayat.pitjarusx.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yumtaufikhidayat.pitjarusx.data.repository.PitjarusXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: PitjarusXRepository
) : ViewModel() {
    fun loginRemote(username: String, password: String) = repository.loginRemote(username, password)

    fun loginLocal(username: String, password: String) = viewModelScope.launch {
        repository.loginLocal(username, password)
    }
}