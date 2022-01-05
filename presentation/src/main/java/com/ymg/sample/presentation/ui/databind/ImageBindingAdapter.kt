package com.ymg.sample.presentation.ui.databind

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ymg.sample.presentation.R



@BindingAdapter("android:load")
fun ImageView.bindImage(url: String?) {
    url?.let {
        Glide.with(context)
            .load(it)
            .placeholder(R.drawable.icon_holder)
            .error(R.drawable.icon_error)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}