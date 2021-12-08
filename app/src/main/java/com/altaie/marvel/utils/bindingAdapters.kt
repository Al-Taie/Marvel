package com.altaie.marvel.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.altaie.marvel.ui.base.BaseAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView


@BindingAdapter("items")
fun <T> RecyclerView.setItems(items: List<T>?) =
    (adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())

@BindingAdapter("image")
fun ShapeableImageView.setImage(imageUrl: String?) = GlideApp.with(context)
    .load(imageUrl)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(this)
