package com.reborn.reborn.data.remote.source

import com.reborn.reborn.data.common.model.MyRoutineList
import com.reborn.reborn.data.remote.api.RoutineApi
import com.reborn.reborn.data.remote.model.VoidResponse
import com.reborn.reborn.data.remote.model.response.MyRoutineListResponse
import com.reborn.reborn.data.remote.model.response.RoutineExerciseResponse
import com.reborn.reborn.data.remote.model.response.RoutineResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoutineDataSource (
    private val routineApi: RoutineApi
){

    fun searchDisease(
    ) : Single<List<RoutineResponse>>{
        return routineApi.searchDisease()
            .subscribeOn(Schedulers.io())
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun exerciseList(
        routineToken : String
    ) : Single<List<RoutineExerciseResponse>>{
        return routineApi.exerciseList(routineToken)
            .subscribeOn(Schedulers.io())
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun saveRoutine(
        routineToken: String,
        totalTime : Int
    ) : Single<VoidResponse>{
        return routineApi.saveRoutine(routineToken, totalTime)
            .subscribeOn(Schedulers.io())
            .map { it }
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun myRoutineList() : Single<List<MyRoutineListResponse>>{
        return routineApi.myRoutineList()
            .subscribeOn(Schedulers.io())
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
    }


}