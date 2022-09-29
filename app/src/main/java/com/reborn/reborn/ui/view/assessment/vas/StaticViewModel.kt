package com.reborn.reborn.ui.view.assessment.vas

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.assessment.rehab.SpotLocationViewModel
import com.reborn.reborn.util.Event

class StaticViewModel: BaseViewModel() {
    val action: MutableLiveData<Event<StaticActions>> = MutableLiveData()

    fun prev(){
        action.value = Event(StaticActions.PREV)
    }

    fun stop(){
        action.value = Event(StaticActions.STOP)
    }

    enum class StaticActions {
        PREV, STOP
    }

}