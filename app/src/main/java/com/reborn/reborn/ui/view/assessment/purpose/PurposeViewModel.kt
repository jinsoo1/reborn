package com.reborn.reborn.ui.view.assessment.purpose

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.account.height.HeightViewModel
import com.reborn.reborn.util.Event

class PurposeViewModel (

): BaseViewModel() {

    val action: MutableLiveData<Event<PurposeActions>> = MutableLiveData()

    fun nextRehab(){
        action.value = Event(PurposeActions.REHAB)
    }

    fun nextMuscle(){
        action.value = Event(PurposeActions.MUSCLE)
    }

    fun nextCorrect(){
        action.value = Event(PurposeActions.CORRECT)
    }

    fun stop(){
        action.value = Event(PurposeActions.STOP)
    }

    enum class PurposeActions {
        REHAB, MUSCLE, CORRECT, STOP
    }
}