package com.reborn.reborn.data.remote.source

import com.reborn.reborn.data.remote.api.ExerciseApi
import com.reborn.reborn.data.remote.model.response.DetailExerciseResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ExerciseDataSource(
    private val exerciseApi: ExerciseApi
) {


    fun detailExercise(
        exerciseToken : String
    ) : Single<DetailExerciseResponse>{
        return exerciseApi.detailExercise(exerciseToken)
            .subscribeOn(Schedulers.io())
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
    }
}