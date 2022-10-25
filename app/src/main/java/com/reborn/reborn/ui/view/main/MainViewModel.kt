package com.reborn.reborn.ui.view.main

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.common.model.MainSearch
import com.reborn.reborn.data.remote.source.SearchDataSource
import com.reborn.reborn.util.Event
import io.reactivex.rxkotlin.addTo

class MainViewModel(
    private val searchDataSource: SearchDataSource
) : BaseViewModel() {

    private val _action : MutableLiveData<Event<MainAction>> = MutableLiveData()
    val action : LiveData<Event<MainAction>> get() = _action

    val _searchQuery : MutableLiveData<String> = MutableLiveData("")
    val searchQuery : LiveData<String> get() = _searchQuery

    private val _searchResult : MutableLiveData<List<MainSearch>> = MutableLiveData(listOf())
    val searchResult : LiveData<List<MainSearch>> get() = _searchResult

    private val _selectItem : MutableLiveData<MainSearch> = MutableLiveData()
    val selectItem : LiveData<MainSearch> get() = _selectItem



    fun actionIsHome(){
        _action.value = Event(MainAction.HOME)
    }


    fun mainSearch(){
        searchDataSource
            .searchDisease(searchQuery.value!!)
            .map {
                Log.d("MainSearch1", it.toString())
                it.map {
                    MainSearch(
                        it.token,
                        it.title,
                        it.type
                    )
                }
            }
            .subscribe({
                Log.d("MainSearch", it.toString())
                val result : List<MainSearch> = if(it.size >= 6){
                    it.subList(0, 5)
                }else{
                    it
                }
                _searchResult.value = result
            },{
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun searchGone(){
        _searchResult.value = listOf()
    }

    fun selectItem(item : MainSearch){
        _selectItem.value = item
    }



    enum class MainAction{
        HOME
    }

    companion object{
        @JvmStatic
        @BindingAdapter("bindSearchResult")
        fun bindSearchResult(rv : RecyclerView, list : List<MainSearch>){
            val adapter = rv.adapter as SearchAdapter
            adapter.let {
                it.updateItems(list)
            }
        }
    }
}