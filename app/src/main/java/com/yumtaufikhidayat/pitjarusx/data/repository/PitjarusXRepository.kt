package com.yumtaufikhidayat.pitjarusx.data.repository

import android.content.Context
import com.yumtaufikhidayat.pitjarusx.data.source.LocalDataSource
import com.yumtaufikhidayat.pitjarusx.data.source.RemoteDataSource
import com.yumtaufikhidayat.pitjarusx.model.local.LoginLocal
import javax.inject.Inject

class PitjarusXRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    fun loginRemote(username: String, password: String) = remoteDataSource.login(username, password)
    suspend fun insertLogin(loginLocal: LoginLocal) = localDataSource.insertLogin(loginLocal)

    fun getLogin() = localDataSource.getLogin()

    suspend fun insertMenu(context: Context) = localDataSource.insertMenu(context)

    fun getMenu() = localDataSource.getMenu()
}