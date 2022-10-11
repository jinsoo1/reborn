package com.reborn.reborn.ui.view.assessment.rehab

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeViewModel
import com.reborn.reborn.util.Event

class CodeViewModel : BaseViewModel() {

    val action: MutableLiveData<Event<CodeActions>> = MutableLiveData()

    fun next(){
        action.value = Event(CodeActions.NEXT)
    }

    fun prev(){
        action.value = Event(CodeActions.PREV)
    }

    fun btnCodeInput(){
        action.value = Event(CodeActions.CODEINPUT)
    }

    fun btnNone(){
        action.value = Event(CodeActions.NONE)
    }

    fun stop(){
        action.value = Event(CodeActions.STOP)
    }


    enum class CodeActions {
        NEXT, PREV, NONE, STOP, CODEINPUT
    }
}