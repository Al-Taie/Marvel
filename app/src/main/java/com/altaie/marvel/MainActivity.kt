package com.altaie.marvel

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.altaie.marvel.data.remote.Resources
import com.altaie.marvel.databinding.ActivityMainBinding
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme: Int = R.style.Theme_Marvel
    override val viewID: Int = R.layout.activity_main
}