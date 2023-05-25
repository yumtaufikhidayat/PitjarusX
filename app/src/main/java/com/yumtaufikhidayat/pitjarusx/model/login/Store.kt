package com.yumtaufikhidayat.pitjarusx.model.login


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.yumtaufikhidayat.pitjarusx.utils.Common

@Entity(tableName = Common.ENTITY_STORE)
data class Store(
    @SerializedName("account_id")
    @PrimaryKey(autoGenerate = false)
    val accountId: String = "", // 1
    @SerializedName("account_name")
    val accountName: String = "", // IDM DUMMY
    @SerializedName("address")
    val address: String = "", // Jalan raya
    @SerializedName("area_id")
    val areaId: String = "", // 1
    @SerializedName("area_name")
    val areaName: String = "", // area 1
    @SerializedName("channel_id")
    val channelId: String = "", // 11
    @SerializedName("channel_name")
    val channelName: String = "", // MT
    @SerializedName("dc_id")
    val dcId: String = "", // 1
    @SerializedName("dc_name")
    val dcName: String = "", // dc 1
    @SerializedName("latitude")
    val latitude: String = "", // -6.3099425
    @SerializedName("longitude")
    val longitude: String = "", // 106.9485818
    @SerializedName("region_id")
    val regionId: String = "", // 1
    @SerializedName("region_name")
    val regionName: String = "", // region 1
    @SerializedName("store_code")
    val storeCode: String = "", // SAT00001
    @SerializedName("store_id")
    val storeId: String = "", // 2
    @SerializedName("store_name")
    val storeName: String = "", // ALFA MART BENDUNGAN
    @SerializedName("subchannel_id")
    val subchannelId: String = "", // 1
    @SerializedName("subchannel_name")
    val subchannelName: String = "" // sub 1
)