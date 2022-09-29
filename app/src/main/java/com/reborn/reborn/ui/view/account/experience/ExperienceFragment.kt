package com.reborn.reborn.ui.view.account.experience

import android.util.Log
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentExperienceBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ExperienceFragment: BaseVmFragment<FragmentExperienceBinding>(
    R.layout.fragment_experience,
    ExperienceViewModel::class.java
) {

    override val viewModel by lazy { vm as ExperienceViewModel }
    private val activityViewModel by sharedViewModel<AccountViewModel>()

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun ExperienceViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                ExperienceViewModel.ExperienceActions.NEXT -> {
                    activityViewModel.switchPageExperience()
                    Log.d("다음", activityViewModel.nextState.value.toString())
                }
                ExperienceViewModel.ExperienceActions.BEGINNER -> {
                    viewModel.beginnerState.value = true
                    viewModel.intermediateState.value = false
                    viewModel.advancedState.value = false
                }
                ExperienceViewModel.ExperienceActions.INTERMEDIATE -> {
                    viewModel.intermediateState.value = true
                    viewModel.beginnerState.value = false
                    viewModel.advancedState.value = false
                }
                ExperienceViewModel.ExperienceActions.ADVANCED -> {
                    viewModel.advancedState.value = true
                    viewModel.intermediateState.value = false
                    viewModel.beginnerState.value = false
                }
            }
        })
    }
}