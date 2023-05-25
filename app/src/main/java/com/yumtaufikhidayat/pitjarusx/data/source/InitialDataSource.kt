package com.yumtaufikhidayat.pitjarusx.data.source

import android.content.Context
import com.yumtaufikhidayat.pitjarusx.R
import com.yumtaufikhidayat.pitjarusx.model.menu.MenuEntity

object InitialDataSource {
    fun getMenu(context: Context) = listOf(
        MenuEntity(
            menuId = 1,
            menuIcon = R.drawable.outline_store,
            menuName = context.getString(R.string.txt_visiting)
        ),
        MenuEntity(
            menuId = 2,
            menuIcon = R.drawable.baseline_radar,
            menuName = context.getString(R.string.txt_target_install_cdfdpc)
        ),
        MenuEntity(
            menuId = 3,
            menuIcon = R.drawable.outline_dashboard,
            menuName = context.getString(R.string.txt_dashboard)
        ),
        MenuEntity(
            menuId = 4,
            menuIcon = R.drawable.outline_assessment,
            menuName = context.getString(R.string.txt_transmission_history)
        ),
        MenuEntity(
            menuId = 5,
            menuIcon = R.drawable.outline_logout,
            menuName = context.getString(R.string.txt_logout)
        ),

    )
}