package com.altaie.marvel.ui.character

import androidx.lifecycle.asLiveData
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.ui.base.BaseViewModel
import com.altaie.marvel.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(repository: MarvelRepositoryImpl) : BaseViewModel(),
    HomeInteractionListener {

    val character = repository.getAllCharacters().asLiveData()

    override fun onRecyclerItemClicked() {

    }

    override fun onRecyclerShowMoreClicked() {
    }

}