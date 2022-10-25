package com.reborn.reborn.ui.view.main.myPage.information

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.UserInformation
import com.reborn.reborn.data.remote.source.UserDataSource
import com.reborn.reborn.util.Event
import com.reborn.reborn.util.ext.onUI
import io.reactivex.rxkotlin.addTo

class InformationViewModel(
    private val userDataSource: UserDataSource
) : BaseViewModel() {

    private val _action : MutableLiveData<Event<InformationAction>> = MutableLiveData()
    val action : MutableLiveData<Event<InformationAction>> get() = _action

    private val _userInfo : MutableLiveData<UserInformation> = MutableLiveData()
    val userInfo : MutableLiveData<UserInformation> get() = _userInfo

    init {
        userDataSource
            .getUserInformation()
            .onUI {

                _userInfo.value = UserInformation(
                    it.name,
                    it.gender?: "",
                    it.birth?: "",
                    it.height,
                    it.weight
                )

                Log.d("asdweq123", it.toString())
            }
            .addTo(compositeDisposable)
    }

    fun genderAction(){
        _action.value = Event(InformationAction.GENDER)
    }


    enum class InformationAction{
        GENDER
    }


}