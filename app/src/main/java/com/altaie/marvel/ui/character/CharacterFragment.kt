package com.altaie.marvel.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.altaie.marvel.databinding.FragmentChaeacterBinding
import com.altaie.marvel.ui.base.BaseFragment
import com.altaie.marvel.ui.home.adapters.CharacterAdapter
import com.altaie.marvel.ui.home.adapters.ComicAdapter

class CharacterFragment : BaseFragment<FragmentChaeacterBinding>() {
    override val viewModel: CharacterViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentChaeacterBinding
        get() = FragmentChaeacterBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.characterRecycler.adapter = CharacterAdapter(emptyList(), viewModel)

    }
}