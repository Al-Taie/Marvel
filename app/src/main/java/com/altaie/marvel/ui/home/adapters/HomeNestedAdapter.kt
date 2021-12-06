package com.altaie.marvel.ui.home.adapters

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.altaie.marvel.BR
import com.altaie.marvel.R
import com.altaie.marvel.ui.base.BaseAdapter
import com.altaie.marvel.ui.home.HomeInteractionListener
import com.altaie.marvel.ui.home.HomeItem


class HomeNestedAdapter(
    private val _items: MutableList<HomeItem>, private val listener: HomeInteractionListener,
) : BaseAdapter<Any>(_items, listener) {
    override var layoutID: Int = R.layout.item_home_parent
    private lateinit var binding: ViewDataBinding

    fun addItem(item: HomeItem) = _items.apply {
        add(item)
        sortBy { it.index }
        setItems(_items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        super.onCreateViewHolder(parent, viewType.also { layoutID = viewType })

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        binding = (holder as ItemViewHolder).binding
        when (val item = _items[position]) {
            is HomeItem.CharactersType -> applyBind(CharacterAdapter(item.data, listener))
            is HomeItem.ComicsType -> applyBind(ComicAdapter(item.data, listener))
            is HomeItem.CreatorsType -> applyBind(CreatorAdapter(item.data, listener))
            is HomeItem.EventsType -> applyBind(EventAdapter(item.data, listener))
            is HomeItem.SeriesType -> applyBind(SeriesAdapter(item.data, listener))
            is HomeItem.StoriesType -> applyBind(StoryAdapter(item.data, listener))
        }
    }

    private fun <T> applyBind(adapter: BaseAdapter<T>) = binding.apply {
        setVariable(BR.listener, listener)
        setVariable(BR.adapter, adapter)
        adapter.items.firstOrNull()?.let { setVariable(BR.title, it::class.simpleName) }
    }

    override fun getItemCount(): Int = _items.size
    override fun getItemViewType(position: Int): Int = _items[position].layoutID
}