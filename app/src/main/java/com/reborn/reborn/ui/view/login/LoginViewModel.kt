package com.reborn.reborn.ui.view.login

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.ui.view.assessment.rehab.CodeViewModel
import com.reborn.reborn.util.Event

class LoginViewModel : BaseViewModel() {

    val action: MutableLiveData<Event<LoginActions>> = MutableLiveData()

    fun kakaoLogin(){
        action.value = Event(LoginActions.KAKAO)
    }


    enum class LoginActions {
       KAKAO
    }
}