package com.reborn.reborn.ui.view.assessment.rehab

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentCodeBinding
import com.reborn.reborn.databinding.FragmentSpotLocationBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SpotLocationFragment : BaseVmFragment<FragmentSpotLocationBinding>(
    R.layout.fragment_spot_location,
    SpotLocationViewModel::class.java
) {

    override val viewModel by lazy { vm as SpotLocationViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()

    override fun initFragment() {

        viewModel.setObserves()
    }

    fun SpotLocationViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                SpotLocationViewModel.LocationActions.PREV -> {
                    activityViewModel.locationPrev()
                }
                SpotLocationViewModel.LocationActions.STOP -> {
                    activityViewModel.finish()
                }
            }
        })
    }
}