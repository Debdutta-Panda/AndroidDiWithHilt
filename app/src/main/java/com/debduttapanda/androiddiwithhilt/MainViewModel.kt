package com.debduttapanda.androiddiwithhilt

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptocurrencyRepository
)
    : ViewModel() {

    private val _list = mutableStateListOf<Cryptocurrency>()
    val list: SnapshotStateList<Cryptocurrency> = _list

    init {
        loadCryptocurrency()
    }

    private fun loadCryptocurrency() {
        viewModelScope.launch {
            val fetchedList = cryptocurrencyRepository.getCryptoCurrency()
            _list.addAll(fetchedList)
        }
    }
}