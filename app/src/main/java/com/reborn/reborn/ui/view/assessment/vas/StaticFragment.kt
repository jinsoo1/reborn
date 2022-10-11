package com.reborn.reborn.ui.view.assessment.vas

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentStaticBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class StaticFragment : BaseVmFragment<FragmentStaticBinding>(
    R.layout.fragment_static,
    StaticViewModel::class.java
) {

    override val viewModel by lazy { vm as StaticViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun StaticViewModel.setObserves() {
        action.observe(viewLifecycleOwner, EventObserver {
            when (it) {
                StaticViewModel.StaticActions.PREV -> {
                    activityViewModel.staticPrev()
                }
                StaticViewModel.StaticActions.STOP -> {
                activityViewModel.finish()
                }
                StaticViewModel.StaticActions.NEXT -> {
                    val actionRehab = StaticFragmentDirections.actionStaticFragmentToDynamicFragment()
                    findNavController().navigate(actionRehab)

                }
            }
        })
    }
}