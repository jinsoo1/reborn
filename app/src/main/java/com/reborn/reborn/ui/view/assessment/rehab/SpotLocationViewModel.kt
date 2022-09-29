package com.reborn.reborn.ui.view.assessment.rehab

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class SpotLocationViewModel: BaseViewModel() {

    val action: MutableLiveData<Event<LocationActions>> = MutableLiveData()

    fun prev(){
        action.value = Event(LocationActions.PREV)
    }

    fun stop(){
        action.value = Event(LocationActions.STOP)
    }

    enum class LocationActions {
        PREV, STOP
    }
}