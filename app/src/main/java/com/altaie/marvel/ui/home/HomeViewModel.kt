package com.altaie.marvel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: MarvelRepositoryImpl) : BaseViewModel(), HomeInteractionListener {
    val characters = repository.getAllCharacters().asLiveData()
    val comics = repository.getAllComics().asLiveData()
    private val charactersDto = repository.getAllCharactersDto().asLiveData()
    private val comicsDto = repository.getAllComicsDto().asLiveData()

    init {
        liveDataLauncher(charactersDto, repository::insertAllCharacters)
        liveDataLauncher(comicsDto, repository::insertAllComics)
    }

    override fun onRecyclerItemClicked() { }
}