package com.altaie.marvel.ui.search

import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.ui.base.BaseViewModel
import com.altaie.marvel.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(repository: MarvelRepositoryImpl) : BaseViewModel()
{

}