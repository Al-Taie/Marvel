package com.altaie.marvel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import com.altaie.marvel.data.remote.State
import com.altaie.marvel.databinding.FragmentHomeBinding
import com.altaie.marvel.domain.models.*
import com.altaie.marvel.ui.base.BaseFragment
import com.altaie.marvel.ui.home.adapters.HomeNestedAdapter
import com.altaie.marvel.utils.castTo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRecycler.adapter = HomeNestedAdapter(mutableListOf(), viewModel)

        with(viewModel) {
            prepareParentAdapter(characters)
            prepareParentAdapter(comics)
            prepareParentAdapter(creators)
            prepareParentAdapter(events)
            prepareParentAdapter(series)
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            Toast.makeText(context, "Refresh", Toast.LENGTH_SHORT).show()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun <T> prepareParentAdapter(liveData: LiveData<State<List<T>>>) {
        liveData.observe(viewLifecycleOwner, { state ->
            (binding.homeRecycler.adapter as HomeNestedAdapter).apply {
                state.toData()?.let { item ->
                    when (item.firstOrNull()) {
                        is Character -> addItem(HomeItem.CharactersType(item.castTo()))
                        is Comic -> addItem(HomeItem.ComicsType(item.castTo()))
                        is Creator -> addItem(HomeItem.CreatorsType(item.castTo()))
                        is Event -> addItem(HomeItem.EventsType(item.castTo()))
                        is Series -> addItem(HomeItem.SeriesType(item.castTo()))
                    }
                }
            }
        })
    }
}