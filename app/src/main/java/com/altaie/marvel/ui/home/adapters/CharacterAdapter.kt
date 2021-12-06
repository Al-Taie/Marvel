package com.altaie.marvel.ui.home.adapters

import com.altaie.marvel.R
import com.altaie.marvel.domain.models.Character
import com.altaie.marvel.ui.base.BaseAdapter
import com.altaie.marvel.ui.base.BaseInteractionListener

class CharacterAdapter(items: List<Character>, listener: BaseInteractionListener) :
    BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_character
}