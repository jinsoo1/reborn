package com.reborn.reborn.ui.view.assessment.vas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class DynamicViewModel: BaseViewModel() {

    val action: MutableLiveData<Event<DynamicActions>> = MutableLiveData()

    private val _num : MutableLiveData<Int> = MutableLiveData(1)
    val num : LiveData<Int> get() = _num

    fun prev(){
        action.value = Event(DynamicActions.PREV)
    }
    fun next(){
        action.value = Event(DynamicActions.NEXT)
    }

    fun stop(){
        action.value = Event(DynamicActions.STOP)
    }

    fun setNum(num : Int){
        _num.value = num
    }

    enum class DynamicActions {
        PREV, STOP, NEXT
    }
}

