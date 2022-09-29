package com.reborn.reborn.ui.view.account

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class AccountViewModel
    : BaseViewModel() {

        val action: MutableLiveData<Event<AccountAction>> = MutableLiveData()
        val nextState: MutableLiveData<Int> = MutableLiveData(0) // 0 : height, 1 : weight, 2: experience, 3 : terms


    fun switchPageHeight(){
        action.value = Event(AccountAction.REPLACE_PAGE_HEIGHT)
    }

    fun switchPageWeight(){
        action.value = Event(AccountAction.REPLACE_PAGE_WEIGHT)
    }

    fun switchPageExperience(){
        action.value = Event(AccountAction.REPLACE_PAGE_EXPERIENCE)
    }

    enum class AccountAction {
        REPLACE_PAGE_HEIGHT, REPLACE_PAGE_WEIGHT, REPLACE_PAGE_EXPERIENCE
    }

}