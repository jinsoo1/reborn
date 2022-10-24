package com.reborn.reborn.ui.view.start

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.local.pref.PreferencesController
import com.reborn.reborn.data.remote.source.AuthDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo

class StartViewModel(
    private val authDataSource: AuthDataSource
) : BaseViewModel() {

    private var _action : MutableLiveData<StartAction> = MutableLiveData()
    val action : MutableLiveData<StartAction> = _action

    init {

        if(PreferencesController.userInfoPref.accessToken.isNotBlank()){
            authDataSource.validateAccessToken()
                .subscribe({
                    Log.d("authData", it.message)
                    if(it.success){
                        if(PreferencesController.userInfoPref.agree){
                            _action.value = StartAction.MOVE_MAIN
                        }else{
                            _action.value = StartAction.MOVE_ACCOUNT
                        }
                    }else{
                        _action.value = StartAction.MOVE_LOGIN
                    }
                },{
                    _action.value = StartAction.MOVE_LOGIN
                    it.printStackTrace()
                })
                .addTo(compositeDisposable)

        }else{
            _action.value = StartAction.MOVE_LOGIN
        }

    }


    enum class StartAction{
        MOVE_LOGIN, MOVE_MAIN, MOVE_ACCOUNT
    }

}