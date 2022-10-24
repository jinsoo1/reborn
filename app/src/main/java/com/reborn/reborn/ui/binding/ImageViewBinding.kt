package com.reborn.reborn.ui.binding

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.reborn.reborn.R

@BindingAdapter("bindImage")
fun ImageView.bindImageURL(url: String?) {
    loadImage(this, url ?: "", false, isProfileImage = false)
}

@BindingAdapter("bindImageDrawable")
fun ImageView.bindImageDrawable(url: Int?) {
    loadImageDrawable(this, url ?: 0, false, isProfileImage = true)
}

@BindingAdapter("bindImageInside")
fun ImageView.bindImageInsideURL(url: String?) {
    loadImageInside(this, url ?: "", false, isProfileImage = false)
}

@BindingAdapter("bindProfileImage")
fun ImageView.bindProfileImageUrl(url: String?) {
    loadImage(this, url ?: "", true, isProfileImage = true)
}

fun loadImage(
    target: ImageView,
    url: String,
    isCircular: Boolean,
    isProfileImage: Boolean
) = target.apply {
    scaleType = ImageView.ScaleType.CENTER_INSIDE

    var request = Glide
        .with(context)
        .load(url)
        .placeholder(
            if (isProfileImage) R.drawable.ic_stamp_gray
            else R.drawable.ic_gallery_post
        )
        .error(
            if (isProfileImage) R.drawable.ic_stamp_gray
            else R.drawable.ic_gallery_post
        )
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.CENTER_CROP
                return false
            }
        })
    if (isCircular) request = request.circleCrop()

    request.into(this)
}

fun loadImageInside(
    target: ImageView,
    url: String,
    isCircular: Boolean,
    isProfileImage: Boolean
) = target.apply {
    scaleType = ImageView.ScaleType.CENTER_INSIDE

    var request = Glide
        .with(context)
        .load(url)
        .placeholder(
            if (isProfileImage) R.drawable.ic_stamp_gray
            else R.drawable.ic_gallery_post
        )
        .error(
            if (isProfileImage) R.drawable.ic_stamp_gray
            else R.drawable.ic_gallery_post
        )
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                return false
            }
        })
    if (isCircular) request = request.circleCrop()

    request.into(this)
}


fun loadImageDrawable(
    target: ImageView,
    url: Int,
    isCircular: Boolean,
    isProfileImage: Boolean
) = target.apply {
    scaleType = ImageView.ScaleType.CENTER_INSIDE

    Log.d("testtest","testtest")

    var request = Glide
        .with(context)
        .load(url)
        .placeholder(
            if (isProfileImage) R.drawable.ic_stamp_gray
            else R.drawable.ic_gallery_post
        )
        .error(
            if (isProfileImage) R.drawable.ic_stamp_gray
            else R.drawable.ic_gallery_post
        )
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.CENTER_CROP
                return false
            }
        })
    if (isCircular) request = request.circleCrop()

    request.into(this)
}