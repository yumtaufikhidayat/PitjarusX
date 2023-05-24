package com.yumtaufikhidayat.pitjarusx.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yumtaufikhidayat.pitjarusx.model.local.StoreEntity
import com.yumtaufikhidayat.pitjarusx.utils.Common

@Database(
    entities = [StoreEntity::class],
    version = Common.DB_VERSION,
    exportSchema = false
)
abstract class PitjarusXDatabase : RoomDatabase() {
    abstract fun getLoginDao(): LoginDao
}