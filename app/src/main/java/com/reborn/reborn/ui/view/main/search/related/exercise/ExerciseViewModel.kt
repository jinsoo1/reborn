package com.reborn.reborn.ui.view.main.search.related.exercise

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.DetailExercise
import com.reborn.reborn.data.remote.source.ExerciseDataSource
import io.reactivex.rxkotlin.addTo

class ExerciseViewModel(
    private val exerciseDataSource: ExerciseDataSource
) : BaseViewModel() {


    private val _exerciseToken : MutableLiveData<String> = MutableLiveData()
    val exerciseToken : MutableLiveData<String> get() = _exerciseToken

    val _detailExercise : MutableLiveData<DetailExercise> = MutableLiveData()
    val detailExercise : MutableLiveData<DetailExercise> get() = _detailExercise



    fun setToken(token : String){
        _exerciseToken.value = token
    }

    fun detailExercise(){

        exerciseDataSource.detailExercise(exerciseToken.value!!)
            .subscribe({
                Log.d("detailExercise", it.toString())
                _detailExercise.value = DetailExercise(it.video, it.videoExplain)
            },{
                Log.d("detailExercise E ", it.toString())
            })
            .addTo(compositeDisposable)

    }

}