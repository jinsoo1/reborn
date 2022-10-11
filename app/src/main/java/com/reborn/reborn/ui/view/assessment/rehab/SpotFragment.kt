package com.reborn.reborn.ui.view.assessment.rehab

import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.Spot
import com.reborn.reborn.databinding.FragmentSpotBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeFragmentDirections
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
            activityViewModel.spotData.value = binding.t1.text.toString()
            Log.d("테스트", "codeData : "+binding.t1.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t2.setOnClickListener {
            activityViewModel.spotData.value = binding.t2.text.toString()
            Log.d("테스트", "codeData : "+binding.t2.text.toString())
            val action2 = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action2)
        }
        binding.t3.setOnClickListener {
            activityViewModel.spotData.value = binding.t3.text.toString()
            Log.d("테스트", "codeData : "+binding.t3.text.toString())
            val action3 = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action3)
        }
        binding.t4.setOnClickListener {
            activityViewModel.spotData.value = binding.t4.text.toString()
            Log.d("테스트", "codeData : "+binding.t4.text.toString())
            val action4 = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action4)
        }
        binding.t5.setOnClickListener {
            activityViewModel.spotData.value = binding.t5.text.toString()
            Log.d("테스트", "codeData : "+binding.t5.text.toString())
            val action5 = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action5)
        }
        binding.t6.setOnClickListener {
            activityViewModel.spotData.value = binding.t6.text.toString()
            Log.d("테스트", "codeData : "+binding.t6.text.toString())
            val action6 = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action6)
        }
        binding.t7.setOnClickListener {
            activityViewModel.spotData.value = binding.t7.text.toString()
            Log.d("테스트", "codeData : "+binding.t7.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t8.setOnClickListener {
            activityViewModel.spotData.value = binding.t8.text.toString()
            Log.d("테스트", "codeData : "+binding.t8.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t9.setOnClickListener {
            activityViewModel.spotData.value = binding.t9.text.toString()
            Log.d("테스트", "codeData : "+binding.t9.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t10.setOnClickListener {
            activityViewModel.spotData.value = binding.t10.text.toString()
            Log.d("테스트", "codeData : "+binding.t10.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t11.setOnClickListener {
            activityViewModel.spotData.value = binding.t11.text.toString()
            Log.d("테스트", "codeData : "+binding.t11.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t12.setOnClickListener {
            activityViewModel.spotData.value = binding.t12.text.toString()
            Log.d("테스트", "codeData : "+binding.t12.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t13.setOnClickListener {
            activityViewModel.spotData.value = binding.t13.text.toString()
            Log.d("테스트", "codeData : "+binding.t13.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t14.setOnClickListener {
            activityViewModel.spotData.value = binding.t14.text.toString()
            Log.d("테스트", "codeData : "+binding.t14.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }
        binding.t15.setOnClickListener {
            activityViewModel.spotData.value = binding.t15.text.toString()
            Log.d("테스트", "codeData : "+binding.t15.text.toString())
            val action = SpotFragmentDirections.actionSpotFragmentToSpotLocationFragment()
            findNavController().navigate(action)
        }

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

//class SpotAdapter(vm: SpotViewModel): BaseRecyclerAdapter<Spot, FragmentSpotBinding>(
//    R.layout.item_spot_list, vm
//)