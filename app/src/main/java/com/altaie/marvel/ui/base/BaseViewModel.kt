package com.altaie.marvel.ui.base

import androidx.lifecycle.*
import com.altaie.marvel.data.remote.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    fun <T> collectValue(repoValue: Flow<T>, liveValue: MutableStateFlow<T>) =
        viewModelScope.launch { repoValue.collect { liveValue.emit(it) } }

    fun <T> liveDataLauncher(
        liveData: LiveData<State<List<T>>>,
        function: suspend (arg: List<T>) -> Unit
    ) {
        viewModelScope.launch { liveData.asFlow().collect { it.toData()?.run { function(this) } } }
    }

    fun <T> liveDataLauncher(
        liveData: MutableLiveData<State<List<T>>>,
        repoValue: Flow<State<List<T>>>
    ) {
        viewModelScope.launch { repoValue.collect { it.toData()?.run { liveData.postValue(it) } } }
    }

    fun launcher(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }
}