package com.reborn.reborn.ui.view.account.height

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class HeightViewModel(

): BaseViewModel() {

    val action: MutableLiveData<Event<HeightActions>> = MutableLiveData()

    private val _height : MutableLiveData<Int> = MutableLiveData(175)
    val height : MutableLiveData<Int> get() = _height

    var setHeight: MutableLiveData<String> = MutableLiveData()

    fun nextWeight(){
        action.value = Event(HeightActions.NEXT)
    }

    enum class HeightActions {
        NEXT
    }

}