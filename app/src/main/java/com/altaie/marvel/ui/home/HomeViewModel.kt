package com.altaie.marvel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.altaie.marvel.domain.MarvelRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: MarvelRepositoryImpl) : ViewModel(), HomeInteractionListener {
    val characters = repository.getAllCharacters().asLiveData()
    val comics = repository.getAllComics().asLiveData()
    val events = repository.getAllEvents().asLiveData()
    val series = repository.getAllSeries().asLiveData()

    override fun onRecyclerItemClicked() { }
}