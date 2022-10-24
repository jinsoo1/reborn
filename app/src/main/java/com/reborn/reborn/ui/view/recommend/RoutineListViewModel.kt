package com.reborn.reborn.ui.view.recommend

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.App.Companion.toast
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.RecommendRoutine
import com.reborn.reborn.data.remote.source.RoutineDataSource
import com.reborn.reborn.util.Event
import io.reactivex.rxkotlin.addTo

class RoutineListViewModel(
    private val routineDataSource: RoutineDataSource
) : BaseViewModel() {

    private val _action : MutableLiveData<Event<RoutineListAction>> = MutableLiveData()
    val action : MutableLiveData<Event<RoutineListAction>> get() = _action

    private val _routineList : MutableLiveData<List<RecommendRoutine>> = MutableLiveData(listOf())
    val routineList : LiveData<List<RecommendRoutine>> get() = _routineList

    private val _isLoading : MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading : LiveData<Boolean> get() = _isLoading

    private val _selectedPreview : MutableLiveData<Event<RecommendRoutine>> = MutableLiveData()
    val selectedPreview : LiveData<Event<RecommendRoutine>> get() = _selectedPreview

    private val _selectedRoutine : MutableLiveData<RecommendRoutine> = MutableLiveData()
    val selectedRoutine : MutableLiveData<RecommendRoutine> get() = _selectedRoutine


    init {
        _isLoading.value = true
        routineDataSource.searchDisease()
            .map {
                it.map {
                    RecommendRoutine(
                        it.routineToken,
                        it.title,
                        it.totalTime
                    )
                }
            }
            .subscribe({
                _isLoading.value = false
               _routineList.value = it
            },{
                _isLoading.value = false
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun selectedPreview(item : RecommendRoutine){
        _selectedPreview.value = Event(item)
    }

    fun selectedItem(item : RecommendRoutine){

        routineList.value!!.forEach {
            it.isSelected.set(false)
        }
        item.isSelected.set(true)
        selectedRoutine.value = item
    }

    fun saveRoutine(){

        if(selectedRoutine.value == null) toast("루틴을 선택해주세요.")
        else{
            routineDataSource.saveRoutine(selectedRoutine.value?.routineToken!!, selectedRoutine.value?.totalTime!!)
                .subscribe({
                    if(it.success){
                       _action.value = Event(RoutineListAction.SAVE)
                       toast("루틴등록을 완료하였습니다.")
                    }
                },{
                    it.printStackTrace()
                })
                .addTo(compositeDisposable)
        }

    }

    enum class RoutineListAction{
        SAVE
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bindRecommendRoutine")
        fun bindRecommendRoutine(rv: RecyclerView, list: List<RecommendRoutine>) {
            val adapter = rv.adapter as RecommendRoutineAdapter
            adapter.let {
                it.updateItems(list)
            }
        }
    }
}