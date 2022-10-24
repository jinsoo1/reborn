package com.reborn.reborn.ui.view.assessment.vas

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentDynamicBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel


class DynamicFragment: BaseVmFragment<FragmentDynamicBinding>(
    R.layout.fragment_dynamic,
    DynamicViewModel::class.java
) {

    override val viewModel by lazy { vm as DynamicViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun DynamicViewModel.setObserves() {
        action.observe(viewLifecycleOwner, EventObserver {
            when (it) {
                DynamicViewModel.DynamicActions.PREV -> {
                    requireActivity().onBackPressed()
                }
                DynamicViewModel.DynamicActions.NEXT -> {
                    activityViewModel.complete()
                }
                DynamicViewModel.DynamicActions.STOP -> {
                    activityViewModel.finish()
                }
            }
        })

        num.observe(this@DynamicFragment, Observer{
            activityViewModel.dynamicData.value = it
        })
    }

}