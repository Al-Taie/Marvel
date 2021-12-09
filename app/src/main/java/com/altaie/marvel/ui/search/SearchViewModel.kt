package com.altaie.marvel.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.altaie.marvel.data.remote.State
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.domain.models.Character
import com.altaie.marvel.ui.base.BaseViewModel
import com.altaie.marvel.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val repository: MarvelRepositoryImpl) : BaseViewModel(),
    HomeInteractionListener {
    val searchQuery = MutableStateFlow<String?>(null)
    val searchStream =
        repository.getAllSearched().asLiveData() as MutableLiveData<State<List<Character>>>

    init {
        searchObserver()
    }

    private fun searchObserver() {
        launcher {
            searchQuery.debounce(1500).collect { query ->
                repository.searchForCharacter(query.toString()).collect(searchStream::postValue)
                if (query.isNullOrEmpty()) loadSearched()
            }
        }
    }

    private fun loadSearched() {
        liveDataLauncher(searchStream, repository.getAllSearched())
    }

    override fun onRecyclerItemClicked() {}

    override fun onRecyclerShowMoreClicked() {}
}