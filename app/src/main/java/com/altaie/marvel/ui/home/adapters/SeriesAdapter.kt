package com.altaie.marvel.ui.home.adapters

import com.altaie.marvel.R
import com.altaie.marvel.domain.models.Comic
import com.altaie.marvel.domain.models.Series
import com.altaie.marvel.ui.base.BaseAdapter
import com.altaie.marvel.ui.base.BaseInteractionListener

class SeriesAdapter(items: List<Series>, listener: BaseInteractionListener) : BaseAdapter<Series>(items, listener) {
    override val layoutID = R.layout.item_series
}