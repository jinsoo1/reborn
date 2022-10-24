package com.reborn.reborn.ui.view.picker

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import com.reborn.reborn.R
import kotlinx.android.synthetic.main.numberpicker_horizontal.view.*
import kotlin.math.abs

class WeightNumberPicker(
    context: Context?,
    attrs: AttributeSet?
) : LinearLayout(context, attrs) {

    private var onSwipeTouchListener: OnSwipeTouchListener
    private var min = 0
    private var max = 0

    private fun calculateNumber(value: Int) {

        tvNumberPicker.text = "$value"
        tvPickerLeft1.text = "${value - 1}"
        tvPickerLeft2.text = "${value - 2}"
        tvPickerLeft3.text = "${value - 4}"
        tvPickerLeft4.text = "${value - 5}"
        tvPickerRight1.text = "${value + 1}"
        tvPickerRight2.text = "${value + 2}"
        tvPickerRight3.text = "${value + 3}"
        tvPickerRight4.text = "${value + 4}"

        when(value){
            30 -> {
                tvPickerLeft4.visibility = GONE
                tvPickerLeft3.visibility = GONE
                tvPickerLeft2.visibility = GONE
                tvPickerLeft1.visibility = GONE
            }
            31 ->{
                tvPickerLeft4.visibility = GONE
                tvPickerLeft3.visibility = GONE
                tvPickerLeft2.visibility = GONE
                tvPickerLeft1.visibility = VISIBLE
            }
            32 ->{
                tvPickerLeft4.visibility = GONE
                tvPickerLeft3.visibility = GONE
                tvPickerLeft2.visibility = VISIBLE
                tvPickerLeft1.visibility = VISIBLE
            }

            148 ->{
                tvPickerRight1.visibility = VISIBLE
                tvPickerRight2.visibility = VISIBLE
                tvPickerRight3.visibility = GONE
                tvPickerRight4.visibility = GONE
            }
            149 ->{
                tvPickerRight1.visibility = VISIBLE
                tvPickerRight2.visibility = GONE
                tvPickerRight3.visibility = GONE
                tvPickerRight4.visibility = GONE
            }
            150 ->{
                tvPickerRight1.visibility = GONE
                tvPickerRight2.visibility = GONE
                tvPickerRight3.visibility = GONE
                tvPickerRight4.visibility = GONE
            }
            else ->{
                tvPickerLeft1.visibility = VISIBLE
                tvPickerLeft2.visibility = VISIBLE
                tvPickerLeft3.visibility = VISIBLE
                tvPickerLeft4.visibility = VISIBLE
                tvPickerRight1.visibility = VISIBLE
                tvPickerRight2.visibility = VISIBLE
                tvPickerRight3.visibility = VISIBLE
                tvPickerRight4.visibility = VISIBLE
            }


        }
    }

    /***
     * HANDLERS
     */
    class OnSwipeTouchListener internal constructor(
        ctx: Context,
        callback: Callback,
        mainView: View
    ) : OnTouchListener {
        private val gestureDetector: GestureDetector
        var context: Context
        var onSwipe: OnSwipeListener? = null
        private var callback: Callback

        private val SWIPE_THRESHOLD = 45
        private val SWIPE_VELOCITY_THRESHOLD = 45

        init {
            gestureDetector = GestureDetector(ctx, GestureListener())
            mainView.setOnTouchListener(this)
            context = ctx
            this.callback = callback
        }

        override fun onTouch(
            v: View,
            event: MotionEvent
        ): Boolean {
            return gestureDetector.onTouchEvent(event)
        }

        inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent): Boolean {
                return true
            }

            override fun onFling(
                e1: MotionEvent,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                var result = false
                try {
                    val diffY = e2.y - e1.y
                    val diffX = e2.x - e1.x
                    if (abs(diffX) > abs(diffY)) {
                        if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD
                        ) {
                            if (diffX > 0) {
                                onSwipeRight()
                            } else {
                                onSwipeLeft()
                            }
                            result = true
                        }
                    } else if (abs(diffY) > SWIPE_THRESHOLD
                        && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD
                    ) {
                        if (diffY > 0) {
                            onSwipeBottom()
                        } else {
                            onSwipeTop()
                        }
                        result = true
                    }
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
                return result
            }
        }

        fun onSwipeRight() {
            callback.swipeRight()
            onSwipe?.swipeRight()
        }

        fun onSwipeLeft() {
            callback.swipeLeft()
            onSwipe?.swipeLeft()
        }

        fun onSwipeTop() {
            onSwipe?.swipeTop()
        }

        fun onSwipeBottom() {
            onSwipe?.swipeBottom()
        }

        interface OnSwipeListener {
            fun swipeRight()
            fun swipeTop()
            fun swipeBottom()
            fun swipeLeft()
        }
    }

    /***
     * GETTERS & SETTERS
     */

    var minValue: Int
        set(minValue) {
            min = minValue
        }
        get() = min

    fun getMaxValue(): Int = max

    fun setMaxValue(max: Int) {
        this.max = max
    }

    var value: Int
        set(value) {
            calculateNumber(value)
        }
        get() {
            if (tvNumberPicker != null) {
                try {
                    val value = tvNumberPicker.text.toString()
                    return value.toInt()
                } catch (ex: NumberFormatException) {
                    Log.e("HorizontalNumberPicker", ex.toString())
                }
            }
            return 0
        }

    init {
        View.inflate(context, R.layout.weight_numberpicker, this)

        onSwipeTouchListener =
            OnSwipeTouchListener(
                getContext(),
                object : Callback {
                    override fun swipeRight(){
                        if(value == 30) {
                            value = 30
                        }else{
                            calculateNumber(value - 1)
                        }
                    }
                    override fun swipeLeft(){
                        if(value == 150) {
                            value = 150
                        }else{
                            calculateNumber(value + 1)
                        }
                    }
                }, findViewById(R.id.layoutNumberPicker)
            )
    }
}