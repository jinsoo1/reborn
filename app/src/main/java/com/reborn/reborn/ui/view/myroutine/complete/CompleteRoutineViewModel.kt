package com.reborn.reborn.ui.view.myroutine.complete

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class CompleteRoutineViewModel : BaseViewModel() {

    private val _action : MutableLiveData<Event<CompleteRoutineAction>> = MutableLiveData()
    val action : MutableLiveData<Event<CompleteRoutineAction>> get() = _action






    fun finishRoutine(){
        _action.value = Event(CompleteRoutineAction.HOME)
    }






    enum class CompleteRoutineAction{
        HOME
    }
}