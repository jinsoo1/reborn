package com.reborn.reborn.ui.binding

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.reborn.reborn.R
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.util.FeedbackPagerAdapter
import com.reborn.reborn.util.ImagePagerAdapter

@BindingAdapter(value = ["bindFeedbackToPager"], requireAll = true)
fun ViewPager2.bindFeedbackToPager(item: List<ExerciseList>?) {

    if(this.adapter == null && item != null) {
        this.adapter = FeedbackPagerAdapter(item)
    }

    this.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    if(item != null){
        (adapter as FeedbackPagerAdapter?)?.updateItems(item)
    }

}