package com.reborn.reborn.ui.view.assessment.vas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.assessment.rehab.SpotLocationViewModel
import com.reborn.reborn.util.Event

class StaticViewModel: BaseViewModel() {
    val action: MutableLiveData<Event<StaticActions>> = MutableLiveData()

    private val _num : MutableLiveData<Int> = MutableLiveData(1)
    val num : LiveData<Int> get() = _num

    fun prev(){
        action.value = Event(StaticActions.PREV)
    }
    fun next(){
        action.value = Event(StaticActions.NEXT)
    }

    fun stop(){
        action.value = Event(StaticActions.STOP)
    }

    fun setNum(num : Int){
        Log.d("NumNumNum", num.toString())
        _num.value = num
    }

    enum class StaticActions {
        PREV, STOP, NEXT
    }

}