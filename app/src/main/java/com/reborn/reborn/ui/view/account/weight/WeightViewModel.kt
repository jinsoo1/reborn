package com.reborn.reborn.ui.view.account.weight

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.account.height.HeightViewModel
import com.reborn.reborn.util.Event

class WeightViewModel(

): BaseViewModel() {

    val action: MutableLiveData<Event<WeightActions>> = MutableLiveData()

    private val _weight : MutableLiveData<Int> = MutableLiveData(60)
    val weight : MutableLiveData<Int> get() = _weight

    var setWeight : MutableLiveData<String> = MutableLiveData()

    fun nextExperience(){
        action.value = Event(WeightActions.NEXT)
    }

    enum class WeightActions {
        NEXT
    }

}