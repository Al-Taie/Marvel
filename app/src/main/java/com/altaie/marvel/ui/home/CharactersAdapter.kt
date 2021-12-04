package com.altaie.marvel.ui.home

import com.altaie.marvel.R
import com.altaie.marvel.domain.models.Character
import com.altaie.marvel.ui.base.BaseAdapter

class CharactersAdapter(items: List<Character>, listener: HomeInteractionListener) : BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_character
}