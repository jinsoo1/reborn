package com.reborn.reborn.ui.view.assessment.rehab

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
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

        binding.t1.setOnClickListener{
            activityViewModel.spotData.value = "N"
            viewModel.next()
        }
        binding.t2.setOnClickListener {
            activityViewModel.spotData.value = "S"
            viewModel.next()
        }
        binding.t3.setOnClickListener {
            activityViewModel.spotData.value = "P"
            viewModel.next()
        }
        binding.t4.setOnClickListener {
            activityViewModel.spotData.value = "AB"
            viewModel.next()
        }
        binding.t5.setOnClickListener {
            activityViewModel.spotData.value = "UA"
            viewModel.next()
        }
        binding.t6.setOnClickListener {
            activityViewModel.spotData.value = "E"
            viewModel.next()
        }
        binding.t7.setOnClickListener {
            activityViewModel.spotData.value = "LA"
            viewModel.next()
        }
        binding.t8.setOnClickListener {
            activityViewModel.spotData.value = "B"
            viewModel.next()
        }
        binding.t9.setOnClickListener {
            activityViewModel.spotData.value = "LB"
            viewModel.next()
        }
        binding.t10.setOnClickListener {
            activityViewModel.spotData.value = "G"
            viewModel.next()
        }
        binding.t11.setOnClickListener {
            activityViewModel.spotData.value = "UL"
            viewModel.next()
        }
        binding.t12.setOnClickListener {
            activityViewModel.spotData.value = "K"
            viewModel.next()
        }
        binding.t13.setOnClickListener {
            activityViewModel.spotData.value = "LL"
            viewModel.next()
        }
        binding.t14.setOnClickListener {
            activityViewModel.spotData.value = "A"
            viewModel.next()
        }


        viewModel.setObserves()

    }

    fun SpotViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                SpotViewModel.SpotActions.PREV -> {
                    requireActivity().onBackPressed()
                }
                SpotViewModel.SpotActions.STOP -> {
                    activityViewModel.finish()
                }
                SpotViewModel.SpotActions.NEXT -> {
                    val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
                    findNavController().navigate(action)
                }

            }
        })
    }
}

