package com.reborn.reborn.ui.view.assessment

import androidx.lifecycle.MutableLiveData
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.data.remote.source.PainDataSource
import com.reborn.reborn.util.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo

class AssessmentViewModel(
  private val painDataSource: PainDataSource
) : BaseViewModel() {

    val action: MutableLiveData<Event<AssessmentAction>> = MutableLiveData()

    val purposeData: MutableLiveData<String> = MutableLiveData()
    val diseaseCodeData: MutableLiveData<String> = MutableLiveData()
    val spotData: MutableLiveData<String> = MutableLiveData()
    val spotPain : MutableLiveData<String> = MutableLiveData()
    val spotPainNum : MutableLiveData<Int> = MutableLiveData()
    val staticData: MutableLiveData<Int> = MutableLiveData()
    val dynamicData: MutableLiveData<Int> = MutableLiveData()

    fun finish(){
        action.value = Event(AssessmentAction.FINISH)
    }

    fun complete(){
        action.value = Event(AssessmentAction.COMPLETE)
    }

    fun setPain(){
        val painSpot = spotData.value + spotPain.value + spotPainNum.value.toString()

        painDataSource.setPain(purposeData.value!!, diseaseCodeData.value!!, painSpot, staticData.value!!, dynamicData.value!!)
            .subscribe({
                if(it.success){
                    action.value = Event(AssessmentAction.PROGRESS)
                }
            },{
                it.printStackTrace()
            })
            .addTo(compositeDisposable)

    }

    enum class AssessmentAction {
        FINISH, COMPLETE, PROGRESS
    }

}