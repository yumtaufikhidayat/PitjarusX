package com.yumtaufikhidayat.pitjarusx.model.menu

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yumtaufikhidayat.pitjarusx.utils.Common

@Entity(tableName = Common.ENTITY_MENU)
data class MenuEntity(
    @PrimaryKey(autoGenerate = false)
    val menuId: Int,
    val menuIcon: Int,
    val menuName: String
)
