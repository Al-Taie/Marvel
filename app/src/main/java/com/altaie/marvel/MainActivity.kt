package com.altaie.marvel

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.altaie.marvel.databinding.ActivityMainBinding
import com.altaie.marvel.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val activityTheme: Int = R.style.Theme_Marvel
    override val viewID: Int = R.layout.activity_main

    override fun onResume() {
        super.onResume()
        binding.bottomNavbar.setupWithNavController(findNavController(R.id.fragment_container))
    }

}