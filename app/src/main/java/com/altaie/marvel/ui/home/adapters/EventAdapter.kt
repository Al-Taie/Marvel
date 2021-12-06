package com.altaie.marvel.ui.home.adapters

import com.altaie.marvel.R
import com.altaie.marvel.domain.models.Comic
import com.altaie.marvel.domain.models.Event
import com.altaie.marvel.ui.base.BaseAdapter
import com.altaie.marvel.ui.base.BaseInteractionListener

class EventAdapter(items: List<Event>, listener: BaseInteractionListener) : BaseAdapter<Event>(items, listener) {
    override val layoutID = R.layout.item_event
}