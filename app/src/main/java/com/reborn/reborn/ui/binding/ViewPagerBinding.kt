package com.reborn.reborn.ui.binding

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.reborn.reborn.util.ImagePagerAdapter

@BindingAdapter(value = ["bindImageToPager", "feedTokens"], requireAll = true)
fun ViewPager2.bindImageToPager(urls: List<String>?, feedTokens : String) {
    Log.d("FeedImageList-B", urls.toString())
    if(this.adapter == null && urls != null) {
        this.adapter = ImagePagerAdapter(urls)
    }
    this.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    if(urls != null){
//        (adapter as ImagePagerAdapter?)?.updateItems(urls.map { FeedPagerItem(it, feedTokens) })
    }

}