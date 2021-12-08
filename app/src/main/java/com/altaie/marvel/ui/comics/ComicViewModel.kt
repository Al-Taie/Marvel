package com.altaie.marvel.ui.comics

import androidx.lifecycle.asLiveData
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.ui.base.BaseViewModel
import com.altaie.marvel.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(repository: MarvelRepositoryImpl) : BaseViewModel(),
    HomeInteractionListener {

    val comics = repository.getAllComics().asLiveData()

    override fun onRecyclerItemClicked() {

    }

    override fun onRecyclerShowMoreClicked() {
    }

}