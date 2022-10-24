package com.reborn.reborn.ui.view.main.search

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.MainSearch
import com.reborn.reborn.data.remote.source.SearchDataSource
import io.reactivex.rxkotlin.addTo


class SearchResultViewModel(
    private val searchDataSource: SearchDataSource
) : BaseViewModel() {

    val _searchState : MutableLiveData<Boolean> = MutableLiveData()
    val searchState : LiveData<Boolean> get() = _searchState

    val _searchData : MutableLiveData<String> = MutableLiveData()
    val searchData : LiveData<String> get() = _searchData

    val _selectToken : MutableLiveData<String> = MutableLiveData()
    val selectToken : LiveData<String> get() = _selectToken

    val _selectType : MutableLiveData<String> = MutableLiveData()
    val selectType : LiveData<String> get() = _selectType

    private val _searchExercise : MutableLiveData<List<MainSearch>> = MutableLiveData(listOf())
    val searchExercise : MutableLiveData<List<MainSearch>> get() = _searchExercise

    private val _searchDisease : MutableLiveData<List<MainSearch>> = MutableLiveData(listOf())
    val searchDisease : MutableLiveData<List<MainSearch>> get() = _searchDisease

    private val _selectItem : MutableLiveData<MainSearch> = MutableLiveData()
    val selectItem : LiveData<MainSearch> get() = _selectItem

    fun searchData(){
        searchDataSource.searchDisease(searchData.value!!)
            .subscribe({ it ->
                Log.d("SearchResult2", it.toString())
                var exercises : MutableList<MainSearch> = mutableListOf()
                var diseases : MutableList<MainSearch> = mutableListOf()
                it.forEach { its ->

                    if(its.type == "exercise"){
                        val exercise = MainSearch(
                            its.token,
                            its.title,
                            its.type
                        )
                        exercises.add(exercise)
                    }else{
                        val disease = MainSearch(
                            its.token,
                            its.title,
                            its.type
                        )
                        diseases.add(disease)
                    }
                }

                _searchExercise.value = exercises
                _searchDisease.value = diseases
            },{
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun selectItem(item : MainSearch){
        _selectItem.value = item
    }


    companion object {
        @JvmStatic
        @BindingAdapter("bindRelated")
        fun bindRelated(rv: RecyclerView, list: List<MainSearch>) {
            val adapter = rv.adapter as RelatedAdapter
            adapter.let {
                it.updateItems(list)
            }
        }
    }

}