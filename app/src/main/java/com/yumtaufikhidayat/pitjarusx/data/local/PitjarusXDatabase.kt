package com.yumtaufikhidayat.pitjarusx.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yumtaufikhidayat.pitjarusx.model.local.LoginLocal
import com.yumtaufikhidayat.pitjarusx.model.login.Store
import com.yumtaufikhidayat.pitjarusx.model.menu.MenuEntity
import com.yumtaufikhidayat.pitjarusx.utils.Common

@Database(
    entities = [
        LoginLocal::class,
        Store::class,
        MenuEntity::class
    ],
    version = Common.DB_VERSION,
    exportSchema = false
)
abstract class PitjarusXDatabase : RoomDatabase() {
    abstract fun getPitjarusXDao(): PitjarusXDao
}