package com.reborn.reborn.ui.view.main.myPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class MyPageNavViewModel : BaseViewModel() {

    val _action : MutableLiveData<Event<NavPageAction>> = MutableLiveData()
    val action : LiveData<Event<NavPageAction>>  get() = _action



    fun moveProfile(){
        _action.value = Event(NavPageAction.PROFILE)
    }

    fun moveInformation(){
        _action.value = Event(NavPageAction.INFORMATION)
    }

    fun moveBookmark(){
        _action.value = Event(NavPageAction.BOOKMARK)
    }

    fun moveHistory(){
        _action.value = Event(NavPageAction.HISTORY)
    }


    enum class NavPageAction{
        PROFILE, INFORMATION, BOOKMARK, HISTORY
    }

}