package com.reborn.reborn.ui.view.main

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class MainViewModel : BaseViewModel() {

    private val _action : MutableLiveData<Event<MainAction>> = MutableLiveData()
    val action : MutableLiveData<Event<MainAction>> get() = _action





    fun actionIsHome(){
        _action.value = Event(MainAction.HOME)
    }




    enum class MainAction{
        HOME
    }
}