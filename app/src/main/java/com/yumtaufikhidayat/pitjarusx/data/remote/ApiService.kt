package com.yumtaufikhidayat.pitjarusx.data.remote

import com.yumtaufikhidayat.pitjarusx.model.login.LoginResponse
import com.yumtaufikhidayat.pitjarusx.utils.Common
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST(Common.LOGIN)
    suspend fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): LoginResponse
}