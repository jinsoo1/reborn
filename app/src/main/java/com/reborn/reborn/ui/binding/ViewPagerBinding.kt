package com.reborn.reborn.ui.binding

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.ui.view.assessment.rehab.SpotLocation
import com.reborn.reborn.ui.view.assessment.rehab.SpotViewPagerAdapter

import com.reborn.reborn.util.FeedbackPagerAdapter

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


//
//@BindingAdapter(value= ["bindSpotToPager"], requireAll = true)
//fun ViewPager2.bindSpotToPager(spot : List<SpotLocation>){
//    if(this.adapter == null){
//        this.adapter = SpotViewPagerAdapter(spot)
//    }
//    this.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//    (adapter as SpotViewPagerAdapter?)?.updateItems(spot)
//}
