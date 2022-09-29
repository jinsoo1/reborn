package com.reborn.reborn.ui.view.main.myPage.profile

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.util.Event

class ProfileViewModel : BaseViewModel(){


    private val _action : MutableLiveData<Event<ProfileAction>> = MutableLiveData()
    val action : MutableLiveData<Event<ProfileAction>> get() = _action


    fun actionIsEdit(){
        _action.value = Event(ProfileAction.Edit)
    }

    enum class ProfileAction{
        Edit
    }
}