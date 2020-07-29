package com.github.tlaabs.githubexplorer.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("circleCrop")
    fun bindImageCircleCrop(view : ImageView, url : String?){
        Glide.with(view.context)
            .load(url)
            .circleCrop()
            .into(view)
    }
}