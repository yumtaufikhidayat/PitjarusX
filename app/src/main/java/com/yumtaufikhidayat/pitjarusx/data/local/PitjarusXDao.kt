package com.yumtaufikhidayat.pitjarusx.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yumtaufikhidayat.pitjarusx.model.login.Store
import com.yumtaufikhidayat.pitjarusx.model.menu.MenuEntity
import com.yumtaufikhidayat.pitjarusx.utils.Common

@Dao
interface PitjarusXDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLogin(listStore: List<Store>)

    @Query("SELECT * FROM ${Common.ENTITY_STORE}")
    fun getLogin(): LiveData<List<Store>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenu(listMenu: List<MenuEntity>)

    @Query("SELECT * FROM ${Common.ENTITY_MENU} ORDER BY ${Common.ENTITY_MENU}.menuId")
    fun getMenu(): LiveData<List<MenuEntity>>
}