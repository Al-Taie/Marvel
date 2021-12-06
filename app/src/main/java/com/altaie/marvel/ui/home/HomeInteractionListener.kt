package com.altaie.marvel.ui.home

import com.altaie.marvel.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onRecyclerItemClicked()
    fun onRecyclerShowMoreClicked()
}