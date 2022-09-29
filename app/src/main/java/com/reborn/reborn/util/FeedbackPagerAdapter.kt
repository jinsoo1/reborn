package com.reborn.reborn.util

import android.widget.RatingBar
import com.reborn.reborn.R
import com.reborn.reborn.base.App.Companion.toast
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.databinding.ItemFeedbackBinding

class FeedbackPagerAdapter(item : List<ExerciseList>) : BaseRecyclerAdapter<ExerciseList, ItemFeedbackBinding>(
    R.layout.item_feedback
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        (holder.binding as ItemFeedbackBinding).apply {
            val position = (position+1).toString()

            tvPosition.text = "$position. "

            rbRating.apply {
                onRatingBarChangeListener = object : RatingBar.OnRatingBarChangeListener{
                    override fun onRatingChanged(
                        ratingBar: RatingBar?,
                        rating: Float,
                        fromUser: Boolean
                    ) {
                        toast(rating.toString())
                    }

                }
            }

            btnDifficultyEasy.setOnClickListener {
                item!!.isDifficulty.set(1)
            }
            btnDifficultyNomal.setOnClickListener {
                item!!.isDifficulty.set(2)
            }
            btnDifficultyHard.setOnClickListener {
                item!!.isDifficulty.set(3)
            }

            btnRepeatFew.setOnClickListener {
                item!!.isRepeat.set(1)
            }
            btnRepeatNomal.setOnClickListener {
                item!!.isRepeat.set(2)
            }
            btnRepeatMany.setOnClickListener {
                item!!.isRepeat.set(3)
            }

            btnRestFew.setOnClickListener {
                item!!.isRest.set(1)
            }
            btnRestNomal.setOnClickListener {
                item!!.isRest.set(2)
            }
            btnRestMany.setOnClickListener {
                item!!.isRest.set(3)
            }

        }


    }

}