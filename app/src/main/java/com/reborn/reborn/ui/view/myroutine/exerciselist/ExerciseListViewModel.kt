package com.reborn.reborn.ui.view.myroutine.exerciselist

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.data.common.model.RoutineList
import com.reborn.reborn.ui.view.myroutine.routinelist.RoutineListAdapter
import com.reborn.reborn.util.Event

class ExerciseListViewModel : BaseViewModel() {

    val routineToken : MutableLiveData<String> = MutableLiveData()

    private val _exerciseList : MutableLiveData<List<ExerciseList>> = MutableLiveData()
    val exerciseList : MutableLiveData<List<ExerciseList>> get() = _exerciseList

    private val _actionData : MutableLiveData<Event<ExerciseStart>> = MutableLiveData()
    val actionData : MutableLiveData<Event<ExerciseStart>> get() = _actionData

    init {

        val itemList : MutableList<ExerciseList> = mutableListOf()

        itemList.add(ExerciseList("123", "대흉근 스트레칭", "15초", "3세트"))
        itemList.add(ExerciseList("456", "후면삼각근 스트레칭", "15초", "3세트"))
        itemList.add(ExerciseList("789", "어깨 회전근 운동", "15초", "3세트"))
        itemList.add(ExerciseList("789", "어깨 회전근 운동", "15초", "3세트"))

        _exerciseList.value = itemList

    }


    fun setActionData(){
        _actionData.value = Event(ExerciseStart.START)
    }

    enum class ExerciseStart{
        START
    }


    companion object{
        @JvmStatic
        @BindingAdapter("bindExerciseList")
        fun bindExerciseList(rv : RecyclerView, list : List<ExerciseList>){
            val adapter = rv.adapter as ExerciseListAdapter
            adapter.let {
                it.updateItems(list)
            }
        }

    }

}