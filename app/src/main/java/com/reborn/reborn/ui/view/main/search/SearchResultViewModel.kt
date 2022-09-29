package com.reborn.reborn.ui.view.main.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel


class SearchResultViewModel : BaseViewModel() {

    private val _state : MutableLiveData<Boolean> = MutableLiveData(true)
    val state : LiveData<Boolean> get() = _state

    private val _setText : MutableLiveData<Boolean> = MutableLiveData()
    val setText : LiveData<Boolean> get() = _setText


    fun setState(state : Boolean){
        _state.value = state
    }

    fun setText(state: Boolean){
        _setText.value = state
    }

}