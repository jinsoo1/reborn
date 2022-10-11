package com.reborn.reborn.ui.view.assessment.purpose

import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentPurposeBinding
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
                PurposeViewModel.PurposeActions.REHAB -> { //재활운동
//                    activityViewModel.clickRehab()

                    val action = PurposeFragmentDirections.actionPurposeFragmentToRehabCodeFragment()
                    findNavController().navigate(action)

                    activityViewModel.purposeData.value = "재활운동"

                }

                PurposeViewModel.PurposeActions.MUSCLE -> { //근력 운동
//                    activityViewModel.clickMuscle()

                    val action = PurposeFragmentDirections.actionPurposeFragmentToRehabCodeFragment()
                    findNavController().navigate(action)

                    activityViewModel.purposeData.value = "근력 운동"

                }

                PurposeViewModel.PurposeActions.CORRECT -> { //교정 운동
//                    activityViewModel.clickCorrect()
                    val action = PurposeFragmentDirections.actionPurposeFragmentToRehabCodeFragment()
                    findNavController().navigate(action)

                    activityViewModel.purposeData.value = "교정 운동"

                }

                PurposeViewModel.PurposeActions.STOP -> { //프로그램 제작 중단
                    activityViewModel.finish()


                }
            }
        })
    }

}