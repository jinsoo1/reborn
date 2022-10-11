package com.reborn.reborn.ui.view.assessment.rehab

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.SpotLocation
import com.reborn.reborn.util.Event

class SpotLocationViewModel: BaseViewModel() {

    val action: MutableLiveData<Event<LocationActions>> = MutableLiveData()
    val clickAction: MutableLiveData<SpotLocation> = MutableLiveData()
    val num: MutableLiveData<Int> = MutableLiveData()

    fun prev(){
        action.value = Event(LocationActions.PREV)
    }

    fun stop(){
        action.value = Event(LocationActions.STOP)
    }

    fun click1(item: SpotLocation){
        clickAction.value = item
        num.value = 1
    }
    fun click2(item: SpotLocation){
        clickAction.value = item
        num.value = 2
    }
    fun click3(item: SpotLocation){
        clickAction.value = item
        num.value = 3
    }
    fun click4(item: SpotLocation){
        clickAction.value = item
        num.value = 4
    }
    fun click5(item: SpotLocation){
        clickAction.value = item
        num.value = 5
    }
    fun click6(item: SpotLocation){
        clickAction.value = item
        num.value = 6
    }
    fun click7(item: SpotLocation){
        clickAction.value = item
        num.value = 7
    }
    fun click8(item: SpotLocation){
        clickAction.value = item
        num.value = 8
    }

    enum class LocationActions {
        PREV, STOP
    }
}