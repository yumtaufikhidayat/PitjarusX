package com.yumtaufikhidayat.pitjarusx.data.remote

import com.yumtaufikhidayat.pitjarusx.model.login.LoginRequest
import com.yumtaufikhidayat.pitjarusx.model.login.LoginResponse
import com.yumtaufikhidayat.pitjarusx.utils.Common
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(Common.LOGIN)
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): LoginResponse
}