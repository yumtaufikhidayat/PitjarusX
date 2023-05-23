package com.yumtaufikhidayat.pitjarusx.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.yumtaufikhidayat.pitjarusx.data.NetworkResult
import com.yumtaufikhidayat.pitjarusx.data.remote.ApiService
import com.yumtaufikhidayat.pitjarusx.model.login.LoginRequest
import com.yumtaufikhidayat.pitjarusx.model.login.LoginResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    fun login(username: String, password: String): LiveData<NetworkResult<LoginResponse>> = liveData {
        emit(NetworkResult.Loading)
        try {
            val loginRequest = LoginRequest(username, password)
            val response = apiService.loginUser(loginRequest)
            emit(NetworkResult.Success(response))
        } catch (e: Exception) {
            val errorMessage = e.message.toString()
            emit(NetworkResult.Error(errorMessage))
        }
    }
}