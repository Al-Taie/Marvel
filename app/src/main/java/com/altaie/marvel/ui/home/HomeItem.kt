package com.altaie.marvel.ui.home

import com.altaie.marvel.R
import com.altaie.marvel.domain.models.*


sealed class HomeItem(val index: Int, val layoutID: Int) {
    class CharactersType(val data: List<Character>) : HomeItem(0, R.layout.item_home_parent)
    class ComicsType(val data: List<Comic>) : HomeItem(1, R.layout.item_home_parent)
    class CreatorsType(val data: List<Creator>) : HomeItem(2, R.layout.item_home_parent)
    class EventsType(val data: List<Event>) : HomeItem(3, R.layout.item_home_parent)
    class SeriesType(val data: List<Series>) : HomeItem(4, R.layout.item_home_parent)
    class StoriesType(val data: List<Story>) : HomeItem(5, R.layout.item_home_parent)
}