package com.reborn.reborn.data.common.model

import androidx.databinding.ObservableInt

data class ExerciseList(
    val exerciseToken : String,
    val title : String,
    val time : String,
    val set : String
){

    var isDifficulty : ObservableInt = ObservableInt()
    var isRepeat : ObservableInt = ObservableInt()
    var isRest : ObservableInt = ObservableInt()

}
