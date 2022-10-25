package com.reborn.reborn.ui.view.main.myPage

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class MyPageViewModel : BaseViewModel() {

    private val _action : MutableLiveData<Event<MyPageAction>> = MutableLiveData()
    val action : MutableLiveData<Event<MyPageAction>> get() = _action



    fun logoutAction(){
        _action.value = Event(MyPageAction.LOGOUT)
    }

    enum class MyPageAction{
        LOGOUT
    }
}