package com.reborn.reborn.ui.view.account.height

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class HeightViewModel(

): BaseViewModel() {

    val action: MutableLiveData<Event<HeightActions>> = MutableLiveData()


    fun nextWeight(){
        action.value = Event(HeightActions.NEXT)
    }

    enum class HeightActions {
        NEXT
    }

}