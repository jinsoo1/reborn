package com.reborn.reborn.ui.view.account.weight

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.account.height.HeightViewModel
import com.reborn.reborn.util.Event

class WeightViewModel(

): BaseViewModel() {

    val action: MutableLiveData<Event<WeightActions>> = MutableLiveData()


    fun nextExperience(){
        action.value = Event(WeightActions.NEXT)
    }

    enum class WeightActions {
        NEXT
    }

}