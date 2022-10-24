package com.reborn.reborn.data.common.model

import androidx.databinding.ObservableBoolean

data class RecommendRoutine(
    val routineToken : String,
    val title : String,
    val totalTime : Int
){
    val isSelected : ObservableBoolean = ObservableBoolean(false)
}
