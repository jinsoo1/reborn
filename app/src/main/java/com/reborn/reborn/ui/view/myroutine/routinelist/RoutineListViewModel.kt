package com.reborn.reborn.ui.view.myroutine.routinelist

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.RoutineList
import com.reborn.reborn.ui.view.main.home.TodayBestExerciseAdapter
import com.reborn.reborn.util.Event


class RoutineListViewModel : BaseViewModel() {

    private val _name : MutableLiveData<String> = MutableLiveData("리본")
    val name : MutableLiveData<String> get() = _name

    private val _routineList : MutableLiveData<List<RoutineList>> = MutableLiveData()
    val routineList : MutableLiveData<List<RoutineList>> get() = _routineList

    private val _actionData : MutableLiveData<Event<RoutineList>> = MutableLiveData()
    val actionData : MutableLiveData<Event<RoutineList>> get() = _actionData


    init {
        val itemList : MutableList<RoutineList> = mutableListOf()

        itemList.add(RoutineList("123", "어깨 맞춤 운동 루틴", "15:20", "22.08.22", "22.09.04"))
        itemList.add(RoutineList("456", "손목 맞춤 운동 루틴", "14:40", "22.08.25", "22.09.07"))
        itemList.add(RoutineList("789", "허리 맞춤 운동 루틴", "20:50", "22.09.02", "22.09.15"))

       _routineList.value = itemList
    }


    fun setActionData(item : RoutineList){
        _actionData.value = Event(item)
    }



    companion object{
        @JvmStatic
        @BindingAdapter("bindRoutineList")
        fun bindRoutineList(rv : RecyclerView, list : List<RoutineList>){
            val adapter = rv.adapter as RoutineListAdapter
            adapter.let {
                it.updateItems(list)
            }
        }

    }
}