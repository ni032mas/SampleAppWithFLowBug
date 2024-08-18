package com.example.sampleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _state = MutableSharedFlow<String>()
    val state: SharedFlow<String> = _state
    init {
        viewModelScope.launch {
            getData()
        }
    }

    private suspend fun getData() {
        _state.emit("Some text")
    }
}