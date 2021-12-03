package com.altaie.marvel.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    fun <T> collectValue(repoValue: Flow<T>, liveValue: MutableStateFlow<T>) =
        viewModelScope.launch { repoValue.collect { liveValue.emit(it) } }

    fun <T> stateFlowLauncher(stateFlow: MutableStateFlow<T>, function: suspend (arg: T) -> Unit) {
        viewModelScope.launch { stateFlow.collect { function(it) } }
    }

    fun launcher(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }
}