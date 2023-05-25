package com.yumtaufikhidayat.pitjarusx.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.yumtaufikhidayat.pitjarusx.utils.Common

@Entity(tableName = Common.ENTITY_LOGIN_LOCAL)
data class LoginLocal(
    @PrimaryKey(autoGenerate = false)
    val username: String,
    val password: String
)