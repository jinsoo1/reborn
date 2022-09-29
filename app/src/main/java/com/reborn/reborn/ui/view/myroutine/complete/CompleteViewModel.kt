package com.reborn.reborn.ui.view.myroutine.complete

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.ui.view.myroutine.exerciselist.ExerciseListAdapter
import com.reborn.reborn.ui.view.myroutine.exerciselist.ExerciseListViewModel
import com.reborn.reborn.util.Event

class CompleteViewModel : BaseViewModel() {

    val routineToken : MutableLiveData<String> = MutableLiveData()

    private val _exerciseList : MutableLiveData<List<ExerciseList>> = MutableLiveData()
    val exerciseList : MutableLiveData<List<ExerciseList>> get() = _exerciseList

    var si : String = "3"
    val bun : String = "23"
    val percent : Int = 86

    private val _actionData : MutableLiveData<Event<CompleteStart>> = MutableLiveData()
    val actionData : MutableLiveData<Event<CompleteStart>> get() = _actionData

    init {

        val itemList : MutableList<ExerciseList> = mutableListOf()

        itemList.add(ExerciseList("123", "대흉근 스트레칭", "15", "3"))
        itemList.add(ExerciseList("456", "후면삼각근 스트레칭", "15", "3"))
        itemList.add(ExerciseList("789", "어깨 회전근 운동", "15", "3"))
        itemList.add(ExerciseList("789", "허리 운동", "15", "3"))

        _exerciseList.value = itemList

    }

    fun setActionData(){
        _actionData.value = Event(CompleteStart.START)
    }

    enum class CompleteStart{
        START
    }



    companion object{
        @JvmStatic
        @BindingAdapter("bindCompleteExerciseList")
        fun bindCompleteExerciseList(rv : RecyclerView, list : List<ExerciseList>){
            val adapter = rv.adapter as CompleteExerciseAdapter
            adapter.let {
                it.updateItems(list)
            }
        }

    }


}