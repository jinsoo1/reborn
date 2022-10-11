package com.reborn.reborn.ui.view.assessment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.util.Event

class AssessmentViewModel
    : BaseViewModel() {

    val action: MutableLiveData<Event<AssessmentAction>> = MutableLiveData()

    val purposeData: MutableLiveData<String> = MutableLiveData()
    val codeData: MutableLiveData<String> = MutableLiveData()
    val spotData: MutableLiveData<String> = MutableLiveData()
    val spotLocationData: MutableLiveData<String> = MutableLiveData()
    val staticData: MutableLiveData<String> = MutableLiveData()
    val dynamicData: MutableLiveData<String> = MutableLiveData()

    fun clickRehab(){
        action.value = Event(AssessmentAction.CLICK_REHAB)

    }
    fun clickMuscle(){
        action.value = Event(AssessmentAction.CLICK_MUSCLE)
    }
    fun clickCorrect(){
        action.value = Event(AssessmentAction.CLICK_CORRECT)
    }

    fun codePrev(){
        action.value = Event(AssessmentAction.CODEPREV)
    }

    fun spotPrev(){
        action.value = Event(AssessmentAction.SPOTPREV)
    }

    fun staticPrev(){
        action.value = Event(AssessmentAction.STATICPREV)
    }

    fun dynamicPrev(){
        action.value = Event(AssessmentAction.DYNAMICPREV)
    }

    fun locationPrev(){
        action.value = Event(AssessmentAction.LOCATIONPREV)
    }

    fun codeNext(){
        action.value = Event(AssessmentAction.CODENEXT)
    }

    fun clickNone(){
        action.value = Event(AssessmentAction.CLICK_NONE)
    }

    fun finish(){
        action.value = Event(AssessmentAction.FINISH)

    }

    enum class AssessmentAction {
        CLICK_REHAB, CLICK_MUSCLE, CLICK_CORRECT, CODEPREV, CODENEXT, CLICK_NONE, SPOTPREV, LOCATIONPREV, FINISH, STATICPREV, DYNAMICPREV
    }

}