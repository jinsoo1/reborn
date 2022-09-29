package com.reborn.reborn.ui.view.myroutine.complete

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentCompleteRoutineBinding
import com.reborn.reborn.util.EventObserver

class CompleteRoutineFragment : BaseVmFragment<FragmentCompleteRoutineBinding>(
    R.layout.fragment_complete_routine,
    CompleteRoutineViewModel::class.java
) {
    override val viewModel by lazy { vm as CompleteRoutineViewModel }

    override fun initFragment() {


        viewModel.setObserves()

    }

    private fun CompleteRoutineViewModel.setObserves(){

        action.observe(this@CompleteRoutineFragment, EventObserver{
            when(it){
                CompleteRoutineViewModel.CompleteRoutineAction.HOME ->{
                    requireActivity().finish()
                }
            }
        })

    }


}