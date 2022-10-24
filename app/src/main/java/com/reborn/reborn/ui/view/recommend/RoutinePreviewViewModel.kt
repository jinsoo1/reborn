package com.reborn.reborn.ui.view.recommend

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.RecommendRoutine
import com.reborn.reborn.data.common.model.RoutineExerciseList
import com.reborn.reborn.data.remote.source.RoutineDataSource
import com.reborn.reborn.ui.view.myroutine.MyRoutineViewModel
import com.reborn.reborn.util.Event
import io.reactivex.rxkotlin.addTo

class RoutinePreviewViewModel(
    private val routineDataSource: RoutineDataSource
) : BaseViewModel() {


    private val _routineToken : MutableLiveData<String> = MutableLiveData()
    val routineToken : MutableLiveData<String> get() = _routineToken

    private val _exerciseList : MutableLiveData<List<RoutineExerciseList>> = MutableLiveData(listOf())
    val exerciseList : MutableLiveData<List<RoutineExerciseList>> get() = _exerciseList

    private val _selectedPreview : MutableLiveData<Event<RoutineExerciseList>> = MutableLiveData()
    val selectedPreview : MutableLiveData<Event<RoutineExerciseList>> get() = _selectedPreview


    fun exerciseList(){
        routineDataSource.exerciseList(routineToken.value!!)
            .map {
                it.map {
                    RoutineExerciseList(
                        it.exerciseToken,
                        it.exerciseName,
                        it.exerciseSet.toString() + "세트"
                    )
                }
            }
            .subscribe({
                Log.d("getExerciseList", it.toString())
                _exerciseList.value = it
            },{
                Log.d("getExerciseList E", it.toString())
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun selectedPreview(item : RoutineExerciseList){
        _selectedPreview.value = Event(item)
    }


    companion object {
        @JvmStatic
        @BindingAdapter("bindRoutineExercise")
        fun bindRoutineExercise(rv: RecyclerView, list: List<RoutineExerciseList>) {
            val adapter = rv.adapter as RoutineExerciseAdapter
            adapter.let {
                it.updateItems(list)
            }
        }
    }
}