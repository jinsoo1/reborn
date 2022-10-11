package com.reborn.reborn.ui.view.assessment.vas

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentDynamicBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.ui.view.assessment.rehab.SpotLocationViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel


class DynamicFragment: BaseVmFragment<FragmentDynamicBinding>(
    R.layout.fragment_static,
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
                    activityViewModel.staticPrev()
                }
                DynamicViewModel.DynamicActions.NEXT -> {
                    val action = DynamicFragmentDirections.actionDynamicFragmentToAnalysisProgressFragment()
                    findNavController().navigate(action)
                }
                DynamicViewModel.DynamicActions.STOP -> {
                    activityViewModel.finish()
                }
            }
        })
    }

}