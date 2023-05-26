package com.yumtaufikhidayat.pitjarusx.ui.store.storelist.viewmodel

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.pitjarusx.data.repository.PitjarusXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoreListViewModel @Inject constructor(
    private val repository: PitjarusXRepository
) : ViewModel() {
    fun getLogin() = repository.getLogin()
}