package com.reborn.reborn.ui.view.main.home

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.TodayBestExercise
import com.reborn.reborn.data.common.model.TodayBestFeed
import com.reborn.reborn.util.Event
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {


    private val _action : MutableLiveData<Event<HomeAction>> = MutableLiveData()
    val action  : MutableLiveData<Event<HomeAction>> get() = _action

    private val _todayBestExercise : MutableLiveData<List<TodayBestExercise>> = MutableLiveData(listOf())
    val todayBestExercise : LiveData<List<TodayBestExercise>> get() = _todayBestExercise


    init {

        viewModelScope.launch {
            val bestExercise = async {  getTodayBestExercise() }

            bestExercise.await()
        }

    }



    private fun getTodayBestExercise(){

        val itemList : MutableList<TodayBestExercise> = mutableListOf()

        itemList.add(TodayBestExercise("first", "허리가 아픈 당신", "이렇게 운동을\n시작해보세요.", "123", "허리"))
        itemList.add(TodayBestExercise("second", "발목이 아픈 당신", "이렇게 운동을\n시작해보세요.", "456", "발목"))
        itemList.add(TodayBestExercise("third", "어깨가 아픈 당신", "이렇게 운동을\n시작해보세요.", "789", "어께"))
        itemList.add(TodayBestExercise("fourth", "뒷목이 아픈 당신", "이렇게 운동을\n시작해보세요.", "124", "뒷목"))
        itemList.add(TodayBestExercise("fifth", "두통이 있는 당신", "이렇게 운동을\n시작해보세요.", "457", "두통"))

        _todayBestExercise.value = itemList

    }

    fun addAssessment(){
        _action.value = Event(HomeAction.ASSESSMENT)
    }


    enum class HomeAction{
        ASSESSMENT
    }


    companion object{
        @JvmStatic
        @BindingAdapter("bindBestExercise")
        fun bindBestExercise(rv : RecyclerView, list : List<TodayBestExercise>){
            val adapter = rv.adapter as TodayBestExerciseAdapter
            adapter.let {
                it.updateItems(list)
            }
        }
    }

}