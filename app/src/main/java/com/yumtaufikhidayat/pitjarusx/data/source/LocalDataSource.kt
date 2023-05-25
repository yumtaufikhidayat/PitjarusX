package com.yumtaufikhidayat.pitjarusx.data.source

import android.content.Context
import com.yumtaufikhidayat.pitjarusx.data.local.PitjarusXDao
import com.yumtaufikhidayat.pitjarusx.model.login.Store
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: PitjarusXDao
) {
    suspend fun insertLogin(listStore: List<Store>) = dao.insertLogin(listStore)

    fun getLogin() = dao.getLogin()

    suspend fun insertMenu(context: Context) = dao.insertMenu(InitialDataSource.getMenu(context))

    fun getMenu() = dao.getMenu()
}