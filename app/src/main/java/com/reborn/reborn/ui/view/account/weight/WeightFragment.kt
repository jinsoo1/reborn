package com.reborn.reborn.ui.view.account.weight

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentWeightBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.picker.PickerAdapterWeight
import com.reborn.reborn.ui.view.picker.PickerLayoutManager
import com.reborn.reborn.ui.view.picker.ScreenUtils
import com.reborn.reborn.util.EventObserver
import kotlinx.android.synthetic.main.fragment_height.*
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.sharedViewModel

class WeightFragment : BaseVmFragment<FragmentWeightBinding>(
    R.layout.fragment_weight,
    WeightViewModel::class.java
) {

    private val data = (0..200).toList()
        .map { it.toString() } as ArrayList<String>

    private lateinit var sliderAdapter: PickerAdapterWeight

    override val viewModel by lazy { vm as WeightViewModel }
    private val activityViewModel by sharedViewModel<AccountViewModel>()

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun WeightViewModel.setObserves(){

        action.observe(this@WeightFragment, EventObserver {
            when(it){
                WeightViewModel.WeightActions.NEXT ->{
                    activityViewModel.setWeight(weight.value!!)
                    findNavController().navigate(R.id.action_weightFragment_to_experienceFragment)
                }
            }
        })

        setWeight.observe(this@WeightFragment, Observer {
            if(it.isNotEmpty()){
                val weight = it.toInt()
                if(weight in 30..150){
                    binding.numberPicker.value = weight
                }
            }
        })

        weight.observe(this@WeightFragment, Observer {
            setWeight.value = it.toString()
        })
    }

}