package com.altaie.marvel.utils

import android.graphics.Color
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
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
fun ShapeableImageView.setImage(imageUrl: String?) {
    val circularProgressDrawable = CircularProgressDrawable(this.context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        setColorSchemeColors(Color.BLUE)
        start()
    }

    val options: RequestOptions = RequestOptions()
        .centerCrop()
        .placeholder(circularProgressDrawable)
        .error(R.drawable.loading_error)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    Glide.with(this.context)
        .load(imageUrl)
        .apply(options)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}