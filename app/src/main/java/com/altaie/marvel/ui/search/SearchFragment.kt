package com.altaie.marvel.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.altaie.marvel.databinding.FragmentSearchBinding
import com.altaie.marvel.databinding.FragmentSeriesBinding
import com.altaie.marvel.ui.base.BaseFragment
import com.altaie.marvel.ui.series.SeriesViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate}
