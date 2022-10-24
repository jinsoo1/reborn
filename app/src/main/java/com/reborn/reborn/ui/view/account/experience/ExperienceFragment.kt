package com.reborn.reborn.ui.view.account.experience

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentExperienceBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.util.EventObserver
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ExperienceFragment: BaseVmFragment<FragmentExperienceBinding>(
    R.layout.fragment_experience,
    ExperienceViewModel::class.java
) {

    override val viewModel by lazy { vm as ExperienceViewModel }
    private val activityViewModel by sharedViewModel<AccountViewModel>()

    override fun initFragment() {

        binding.btnNext.isEnabled = false

        viewModel.setObserves()

    }

    fun ExperienceViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                ExperienceViewModel.ExperienceActions.NEXT -> {
                    if(beginnerState.value!!){
                        activityViewModel.setLevel("beginner")
                    }else if(intermediateState.value!!){
                        activityViewModel.setLevel("intermediate")
                    }else if(advancedState.value!!) {
                        activityViewModel.setLevel("Advanced")
                    }
                    findNavController().navigate(R.id.action_experienceFragment_to_termsFragment)
                }
                ExperienceViewModel.ExperienceActions.BEGINNER -> {
                    beginnerState.value = true
                    intermediateState.value = false
                    advancedState.value = false

                    btnEnabled()
                }
                ExperienceViewModel.ExperienceActions.INTERMEDIATE -> {
                    intermediateState.value = true
                    beginnerState.value = false
                    advancedState.value = false

                    btnEnabled()
                }
                ExperienceViewModel.ExperienceActions.ADVANCED -> {
                    advancedState.value = true
                    intermediateState.value = false
                    beginnerState.value = false

                    btnEnabled()
                }
            }
        })

        btnState.observe(this@ExperienceFragment, Observer {
            if(it){
                binding.btnNext.isEnabled = true
            }
        })
    }
}