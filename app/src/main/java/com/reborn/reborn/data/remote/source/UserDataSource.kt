package com.reborn.reborn.data.remote.source

import com.reborn.reborn.data.remote.api.UserApi
import com.reborn.reborn.data.remote.model.DataResponse
import com.reborn.reborn.data.remote.model.VoidResponse
import com.reborn.reborn.data.remote.model.response.UserInformationResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserDataSource(
    private val userApi : UserApi
) {

    fun setAccount(
        height : Int,
        weight : Int,
        level : String,
        terms : Int
    ) : Single<VoidResponse> {
        return userApi.setAccount(height, weight, level, terms)
            .subscribeOn(Schedulers.io())
            .map { it }
            .observeOn(AndroidSchedulers.mainThread())
    }


    fun getUserInformation() : Single<UserInformationResponse>{
        return userApi.getUserInformation()
            .subscribeOn(Schedulers.io())
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
    }




}