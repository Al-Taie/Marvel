package com.altaie.marvel.ui.home.adapters

import com.altaie.marvel.R
import com.altaie.marvel.databinding.ItemComicBinding
import com.altaie.marvel.domain.models.Comic
import com.altaie.marvel.domain.models.Creator
import com.altaie.marvel.ui.base.BaseAdapter
import com.altaie.marvel.ui.base.BaseInteractionListener

class CreatorAdapter(items: List<Creator>, listener: BaseInteractionListener) : BaseAdapter<Creator>(items, listener) {
    override val layoutID = R.layout.item_creator
}