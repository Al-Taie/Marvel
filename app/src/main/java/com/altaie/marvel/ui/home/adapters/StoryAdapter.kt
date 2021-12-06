package com.altaie.marvel.ui.home.adapters

import com.altaie.marvel.R
import com.altaie.marvel.domain.models.Comic
import com.altaie.marvel.domain.models.Story
import com.altaie.marvel.ui.base.BaseAdapter
import com.altaie.marvel.ui.base.BaseInteractionListener

class StoryAdapter(items: List<Story>, listener: BaseInteractionListener) : BaseAdapter<Story>(items, listener) {
    override val layoutID = R.layout.item_story
}