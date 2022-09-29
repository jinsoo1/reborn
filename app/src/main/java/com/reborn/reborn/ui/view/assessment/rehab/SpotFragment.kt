package com.reborn.reborn.ui.view.assessment.rehab

import androidx.recyclerview.widget.GridLayoutManager
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.Spot
import com.reborn.reborn.databinding.FragmentCodeBinding
import com.reborn.reborn.databinding.FragmentSpotBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SpotFragment: BaseVmFragment<FragmentSpotBinding>(
    R.layout.fragment_spot,
    SpotViewModel::class.java
) {

    override val viewModel by lazy { vm as SpotViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()

    override fun initFragment() {

        val gridLayoutManager = GridLayoutManager(requireContext(), 4)
        binding.rvSpot.layoutManager = gridLayoutManager
        binding.rvSpot.adapter = SpotAdapter(viewModel)
        viewModel.setObserves()

    }

    fun SpotViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                SpotViewModel.SpotActions.PREV -> {
                    activityViewModel.spotPrev()
                }
                SpotViewModel.SpotActions.STOP -> {
                    activityViewModel.finish()
                }
            }
        })
    }
}

class SpotAdapter(vm: SpotViewModel): BaseRecyclerAdapter<Spot, FragmentSpotBinding>(
    R.layout.item_spot_list, vm
)