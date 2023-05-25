package com.yumtaufikhidayat.pitjarusx.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yumtaufikhidayat.pitjarusx.data.repository.PitjarusXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PitjarusXRepository
) : ViewModel() {
    fun insertMenu(context: Context) = viewModelScope.launch {
        repository.insertMenu(context)
    }

    fun getMenu() = repository.getMenu()
}