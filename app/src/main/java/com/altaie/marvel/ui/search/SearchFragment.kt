package com.altaie.marvel.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.altaie.marvel.databinding.FragmentSearchBinding
import com.altaie.marvel.databinding.FragmentSeriesBinding
import com.altaie.marvel.ui.base.BaseFragment
import com.altaie.marvel.ui.home.adapters.CharacterAdapter
import com.altaie.marvel.ui.series.SeriesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRecycler.adapter = CharacterAdapter(emptyList(), viewModel)
    }
}
