package com.reborn.reborn.ui.view.account.height

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentHeightBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class HeightFragment: BaseVmFragment<FragmentHeightBinding>(
    R.layout.fragment_height,
    HeightViewModel::class.java
) {

    override val viewModel by lazy { vm as HeightViewModel }

    private val activityViewModel by sharedViewModel<AccountViewModel>()

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun HeightViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                HeightViewModel.HeightActions.NEXT -> {
                    activityViewModel.setHeight(height.value!!)
                    findNavController().navigate(R.id.action_heightFragment_to_weightFragment)
                }
            }
        })

        setHeight.observe(this@HeightFragment, Observer {

            if(it.isNotEmpty()){
                val height = it.toInt()
                if(height in 130..200) {
                    binding.numberPicker.value = height
                }
            }

        })

        height.observe(this@HeightFragment, Observer {
            setHeight.value = it.toString()
        })



    }

}