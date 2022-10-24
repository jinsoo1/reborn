package com.reborn.reborn.ui.view.account.experience

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.account.height.HeightViewModel
import com.reborn.reborn.util.Event

class ExperienceViewModel(

): BaseViewModel() {

    val action: MutableLiveData<Event<ExperienceActions>> = MutableLiveData()

    val beginnerState: MutableLiveData<Boolean> = MutableLiveData(false) //false 클릭 안된 상태 true 클릭된 상태
    val intermediateState: MutableLiveData<Boolean> = MutableLiveData(false) //false 클릭 안된 상태 true 클릭된 상태
    val advancedState: MutableLiveData<Boolean> = MutableLiveData(false) //false 클릭 안된 상태 true 클릭된 상태

    private val _btnState : MutableLiveData<Boolean> = MutableLiveData(false)
    val btnState : MutableLiveData<Boolean> get() = _btnState


    fun nextTerms(){
        action.value = Event(ExperienceActions.NEXT)
    }

    fun clickBeginner(){
        action.value = Event(ExperienceActions.BEGINNER)
    }

    fun clickIntermediate(){
        action.value = Event(ExperienceActions.INTERMEDIATE)
    }

    fun clickAdvanced(){
        action.value = Event(ExperienceActions.ADVANCED)
    }

    fun btnEnabled(){
        _btnState.value = true
    }


    enum class ExperienceActions {
        NEXT, BEGINNER, INTERMEDIATE, ADVANCED
    }
}