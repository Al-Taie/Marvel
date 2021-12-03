package com.altaie.marvel.ui.home

import com.altaie.marvel.R
import com.altaie.marvel.data.remote.response.characters.CharacterDto
import com.altaie.marvel.ui.base.BaseAdapter

class CharactersAdapter(items: List<CharacterDto>, listener: HomeInteractionListener) : BaseAdapter<CharacterDto>(items, listener) {
    override val layoutID = R.layout.item_character
}