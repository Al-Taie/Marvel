package com.altaie.marvel.utils

import android.content.Context
import android.graphics.Color
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.altaie.marvel.R
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Priority
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions


@GlideModule
class GlideAppModule :
    AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)

        val circularProgressDrawable = CircularProgressDrawable(context).apply {
            strokeWidth = 5f
            centerRadius = 30f
            setColorSchemeColors(Color.BLUE)
            start()
        }

        builder.setDefaultRequestOptions(
            RequestOptions()
                .centerCrop()
                .placeholder(circularProgressDrawable)
                .error(R.drawable.loading_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
        )
    }
}