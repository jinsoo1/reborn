package com.reborn.reborn.ui.view.assessment.vas

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class DynamicViewModel: BaseViewModel() {

    val action: MutableLiveData<Event<DynamicActions>> = MutableLiveData()

    fun prev(){
        action.value = Event(DynamicActions.PREV)
    }

    fun stop(){
        action.value = Event(DynamicActions.STOP)
    }

    enum class DynamicActions {
        PREV, STOP
    }
}