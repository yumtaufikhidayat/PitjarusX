package com.yumtaufikhidayat.pitjarusx.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yumtaufikhidayat.pitjarusx.utils.Common

@Entity(tableName = Common.ENTITY_STORE)
data class StoreEntity(
    @PrimaryKey(autoGenerate = false)
    val accountId: String, // 1
    val accountName: String, // IDM DUMMY
    val address: String, // Jalan raya
    val areaId: String, // 1
    val areaName: String, // area 1
    val channelId: String, // 11
    val channelName: String, // MT
    val dcId: String, // 1
    val dcName: String, // dc 1
    val latitude: String, // -6.3099425
    val longitude: String, // 106.9485818
    val regionId: String, // 1
    val regionName: String, // region 1
    val storeCode: String, // SAT00001
    val storeId: String, // 2
    val storeName: String, // ALFA MART BENDUNGAN
    val subchannelId: String, // 1
    val subchannelName: String // sub 1
)