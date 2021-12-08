package com.altaie.marvel.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.altaie.marvel.databinding.FragmentComicBinding
import com.altaie.marvel.ui.base.BaseFragment
import com.altaie.marvel.ui.character.CharacterViewModel
import com.altaie.marvel.ui.home.adapters.ComicAdapter

class ComicFragment : BaseFragment<FragmentComicBinding>() {
    override val viewModel: ComicViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentComicBinding
        get() = FragmentComicBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.comicsRecycler.adapter = ComicAdapter(emptyList(), viewModel)

    }
}