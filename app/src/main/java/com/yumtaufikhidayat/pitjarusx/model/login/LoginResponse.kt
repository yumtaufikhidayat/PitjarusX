package com.yumtaufikhidayat.pitjarusx.model.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: String = "", // success
    @SerializedName("stores")
    val stores: List<Store> = listOf()
)