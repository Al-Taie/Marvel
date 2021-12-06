package com.altaie.marvel.ui.home.adapters

import com.altaie.marvel.R
import com.altaie.marvel.databinding.ItemComicBinding
import com.altaie.marvel.domain.models.Comic
import com.altaie.marvel.ui.base.BaseAdapter
import com.altaie.marvel.ui.base.BaseInteractionListener

class ComicAdapter(items: List<Comic>, listener: BaseInteractionListener) : BaseAdapter<Comic>(items, listener) {
    override val layoutID = R.layout.item_comic
}