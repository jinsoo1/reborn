package com.reborn.reborn.ui.view.main.myPage.information

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.UserInformation
import com.reborn.reborn.data.remote.source.UserDataSource
import com.reborn.reborn.util.ext.onUI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo

class InformationViewModel(
    private val userDataSource: UserDataSource
) : BaseViewModel() {

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






}