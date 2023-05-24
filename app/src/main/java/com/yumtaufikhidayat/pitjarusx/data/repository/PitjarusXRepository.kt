package com.yumtaufikhidayat.pitjarusx.data.repository

import com.yumtaufikhidayat.pitjarusx.data.source.LocalDataSource
import com.yumtaufikhidayat.pitjarusx.data.source.RemoteDataSource
import javax.inject.Inject

class PitjarusXRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    fun loginRemote(username: String, password: String) = remoteDataSource.login(username, password)
    suspend fun loginLocal(username: String, password: String) = localDataSource.login(username, password)
}