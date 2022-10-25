package com.reborn.reborn.ui.view.main.myPage.history

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.MyRoutineList
import com.reborn.reborn.data.remote.source.RoutineDataSource
import io.reactivex.rxkotlin.addTo

class HistoryViewModel(
    private val routineDataSource: RoutineDataSource
) : BaseViewModel() {

    private val _myRoutine : MutableLiveData<List<MyRoutineList>> = MutableLiveData(listOf())
    val myRoutine : MutableLiveData<List<MyRoutineList>> get() = _myRoutine


    init {

        routineDataSource.myRoutineList()
            .map {
                it.map {
                    MyRoutineList(
                        it.rLogNum,
                        it.playTime,
                        it.totalTime.toInt(),
                        it.routineToken,
                        it.routineName
                    )
                }
            }
            .subscribe({
                Log.d("MyRoutineList", it.toString())
                _myRoutine.value = it
            },{
                Log.d("MyRoutineList E ", it.toString())
            })
            .addTo(compositeDisposable)
    }


    companion object {
        @JvmStatic
        @BindingAdapter("bindMyRoutine")
        fun bindMyRoutine(rv: RecyclerView, list: List<MyRoutineList>) {
            val adapter = rv.adapter as MyRoutineListAdapter
            adapter.let {
                it.updateItems(list)
            }
        }
    }

}