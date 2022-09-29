package com.reborn.reborn.ui.view.assessment.rehab

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeViewModel
import com.reborn.reborn.util.Event

class SpotViewModel: BaseViewModel() {

    val action: MutableLiveData<Event<SpotActions>> = MutableLiveData()

    fun prev(){
        action.value = Event(SpotActions.PREV)
    }

    fun stop(){
        action.value = Event(SpotActions.STOP)
    }

    enum class SpotActions {
        PREV, STOP
    }
}