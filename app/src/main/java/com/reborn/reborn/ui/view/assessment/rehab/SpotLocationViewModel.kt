package com.reborn.reborn.ui.view.assessment.rehab

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class SpotLocationViewModel: BaseViewModel() {

    val action: MutableLiveData<Event<LocationActions>> = MutableLiveData()

    val num: MutableLiveData<Event<Int>> = MutableLiveData()


    private val _spotData : MutableLiveData<List<SpotLocation>> = MutableLiveData()
    val spotData : MutableLiveData<List<SpotLocation>> get() = _spotData

    fun prev(){
        action.value = Event(LocationActions.PREV)
    }

    fun stop(){
        action.value = Event(LocationActions.STOP)
    }

    fun click1(){

        num.value = Event(1)
    }
    fun click2(){

        num.value = Event(2)
    }
    fun click3(){

        num.value = Event(3)
    }
    fun click4(){

        num.value = Event(4)
    }
    fun click5(){

        num.value = Event(5)
    }
    fun click6(){

        num.value = Event(6)
    }
    fun click7(){

        num.value = Event(7)
    }
    fun click8(){

        num.value = Event(8)
    }

    enum class LocationActions {
        PREV, STOP
    }
}
data class SpotLocation(
    val spot2 : String,
    val spotList : Int,
    val spotImg : Int
)