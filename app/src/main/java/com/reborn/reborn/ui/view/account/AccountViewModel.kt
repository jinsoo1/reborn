package com.reborn.reborn.ui.view.account

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.local.pref.PreferencesController
import com.reborn.reborn.data.remote.source.UserDataSource
import com.reborn.reborn.util.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import org.jetbrains.anko.internals.AnkoInternals.createAnkoContext

class AccountViewModel(
    private val userDataSource: UserDataSource
        ): BaseViewModel() {

    val action: MutableLiveData<Event<AccountAction>> = MutableLiveData()

    private val _height : MutableLiveData<Int> = MutableLiveData()
    val height : LiveData<Int> get() = _height

    private val _weight : MutableLiveData<Int> = MutableLiveData()
    val weight : LiveData<Int> get() = _weight

    private val _level : MutableLiveData<String> = MutableLiveData()
    val level : LiveData<String> get() = _level

    private val _terms : MutableLiveData<Int> = MutableLiveData()
    val terms : LiveData<Int> get() = _terms

    private val _isLoading : MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading : LiveData<Boolean> get() = _isLoading


    fun setHeight(data : Int){
        _height.value = data
    }

    fun setWeight(data : Int){
        _weight.value = data
    }

    fun setLevel(data : String){
        _level.value = data
    }

    fun setTerms(data : Int){
        _terms.value = data
    }

    fun uploadMyAccount(){

        _isLoading.value = true

        userDataSource
            .setAccount(height.value!!, weight.value!!, level.value!!, terms.value!!)
            .subscribe({
                if(it.success){
                    PreferencesController.userInfoPref.agree = true
                    action.value = Event(AccountAction.SUCCESS)
                    _isLoading.value = false
                }
            },{
                it.printStackTrace()
                Log.d("authData", it.toString())
            }
            )
            .addTo(compositeDisposable)



    }


    enum class AccountAction {
        SUCCESS
    }

}