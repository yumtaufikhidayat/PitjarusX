package com.yumtaufikhidayat.pitjarusx.data.repository

import com.yumtaufikhidayat.pitjarusx.data.source.RemoteDataSource
import javax.inject.Inject

class PitjarusXRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    fun login(username: String, password: String) = remoteDataSource.login(username, password)
}