package com.reborn.reborn.ui.view.myroutine.feedback

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.util.Event

class FeedbackViewModel : BaseViewModel() {

    private val _action : MutableLiveData<Event<ShowDialog>> = MutableLiveData()
    val action : MutableLiveData<Event<ShowDialog>> get() = _action

    private val _exerciseList : MutableLiveData<List<ExerciseList>> = MutableLiveData()
    val exerciseList : MutableLiveData<List<ExerciseList>> get() = _exerciseList


    init {

        val itemList : MutableList<ExerciseList> = mutableListOf()

        itemList.add(ExerciseList("123", "대흉근 스트레칭", "15", "3"))
        itemList.add(ExerciseList("456", "후면삼각근 스트레칭", "15", "3"))
        itemList.add(ExerciseList("789", "어깨 회전근 운동", "15", "3"))
        itemList.add(ExerciseList("789", "허리 운동", "15", "3"))

        _exerciseList.value = itemList

    }


    fun onContinueDialog(){
        _action.value = Event(ShowDialog.SHOW)
    }



    enum class ShowDialog {
        SHOW
    }



}