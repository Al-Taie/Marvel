package com.altaie.marvel.ui.series

import androidx.lifecycle.asLiveData
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.ui.base.BaseViewModel
import com.altaie.marvel.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(repository: MarvelRepositoryImpl) : BaseViewModel(),
    HomeInteractionListener {

    val series = repository.getAllSeries().asLiveData()

    override fun onRecyclerItemClicked() {

    }

    override fun onRecyclerShowMoreClicked() {
    }

}