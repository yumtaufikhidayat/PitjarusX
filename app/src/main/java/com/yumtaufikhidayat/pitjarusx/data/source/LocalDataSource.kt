package com.yumtaufikhidayat.pitjarusx.data.source

import com.yumtaufikhidayat.pitjarusx.data.local.LoginDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val localSource: LoginDao
) {
    suspend fun login(username: String, password: String) = localSource.login(username, password)
}