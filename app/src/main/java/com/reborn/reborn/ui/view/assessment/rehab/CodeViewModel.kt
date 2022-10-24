package com.reborn.reborn.ui.view.assessment.rehab

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeViewModel
import com.reborn.reborn.util.Event

class CodeViewModel : BaseViewModel() {

    val action: MutableLiveData<Event<CodeActions>> = MutableLiveData()

    private val _codeText : MutableLiveData<String> = MutableLiveData("")
    val codeText : MutableLiveData<String> get() = _codeText

    val typeState: MutableLiveData<Boolean> = MutableLiveData(false) //true이면 없음, false이면 있음

    private val _btnState : MutableLiveData<Boolean> = MutableLiveData(false)
    val btnState  : MutableLiveData<Boolean> get() = _btnState

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