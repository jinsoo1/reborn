package com.reborn.reborn.data.remote.source

import com.reborn.reborn.data.remote.api.PainApi
import com.reborn.reborn.data.remote.model.VoidResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PainDataSource(
    private val painApi: PainApi
) {


    fun setPain(
        purpose : String,
        diseaseCode : String,
        painSpot : String,
        static : Int,
        dynamic : Int
    ) : Single<VoidResponse>{
        return painApi.setPain(purpose, diseaseCode, painSpot, static, dynamic)
            .subscribeOn(Schedulers.io())
            .map { it }
            .observeOn(AndroidSchedulers.mainThread())
    }


}