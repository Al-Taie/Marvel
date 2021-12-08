package com.altaie.marvel.ui.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.altaie.marvel.databinding.FragmentSeriesBinding
import com.altaie.marvel.ui.base.BaseFragment
import com.altaie.marvel.ui.home.adapters.SeriesAdapter
import com.altaie.marvel.ui.series.SeriesViewModel

class SeriesFragment : BaseFragment<FragmentSeriesBinding>() {
    override val viewModel: SeriesViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSeriesBinding
        get() = FragmentSeriesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.seriesRecycler.adapter = SeriesAdapter(emptyList(), viewModel)

    }
}