package com.reborn.reborn.ui.view.assessment.purpose

import android.util.Log
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentPurposeBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.account.height.HeightViewModel
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class PurposeFragment: BaseVmFragment<FragmentPurposeBinding>(
    R.layout.fragment_purpose,
    PurposeViewModel::class.java
) {

    override val viewModel by lazy { vm as PurposeViewModel }

    private val activityViewModel by sharedViewModel<AssessmentViewModel>()

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun PurposeViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                PurposeViewModel.PurposeActions.REHAB -> {
                    activityViewModel.clickRehab()

                }

                PurposeViewModel.PurposeActions.MUSCLE -> {
                    activityViewModel.clickMuscle()

                }

                PurposeViewModel.PurposeActions.CORRECT -> {
                    activityViewModel.clickCorrect()

                }

                PurposeViewModel.PurposeActions.STOP -> {
                    activityViewModel.finish()

                }
            }
        })
    }

}