package com.reborn.reborn.ui.view.account.terms

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class TermsViewModel(): BaseViewModel() {

    val action : MutableLiveData<Event<TermsAction>> = MutableLiveData()


    fun finishAction(){
        action.value = Event(TermsAction.FINISH)
    }





    enum class TermsAction{
        FINISH
    }
}