package com.altaie.marvel.utils.bindingAdapters

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.altaie.marvel.R
import com.altaie.marvel.ui.base.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.imageview.ShapeableImageView


@BindingAdapter("items")
fun <T> RecyclerView.setItems(items: List<T>?) {
    (adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter("image")
fun ShapeableImageView.setImage(imagePath: String?) {
    val options: RequestOptions = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.progress_animation)
        .error(R.drawable.load_error)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .dontAnimate()
        .dontTransform()

    Glide.with(this)
        .load("$imagePath.jpg")
        .apply(options)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}