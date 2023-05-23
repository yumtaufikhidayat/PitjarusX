package com.yumtaufikhidayat.pitjarusx.ui.login

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.pitjarusx.data.repository.PitjarusXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: PitjarusXRepository
) : ViewModel() {
    fun login(username: String, password: String) = repository.login(username, password)
}