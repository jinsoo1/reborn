package com.reborn.reborn.ui.view.recommend

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.RecommendRoutine
import com.reborn.reborn.databinding.FragmentRecommendRoutineListBinding
import com.reborn.reborn.databinding.ItemRecommendRoutineListBinding
import com.reborn.reborn.util.EventObserver

class RoutineListFragment : BaseVmFragment<FragmentRecommendRoutineListBinding>(
    R.layout.fragment_recommend_routine_list,
    RoutineListViewModel::class.java
) {
    override val viewModel: RoutineListViewModel by lazy { vm as RoutineListViewModel }

    override fun initFragment() {

        binding.apply {
            rvRoutineList.apply {
                adapter = RecommendRoutineAdapter(viewModel)
            }
        }

        viewModel.setObserves()

    }

    private fun RoutineListViewModel.setObserves(){

        action.observe(this@RoutineListFragment, EventObserver{
            when(it){
                RoutineListViewModel.RoutineListAction.SAVE ->{
                    requireActivity().finish()
                }
            }
        })

        selectedPreview.observe(this@RoutineListFragment, EventObserver {
            val action = RoutineListFragmentDirections.actionRoutineListFragment2ToRoutinePreviewFragment(it.routineToken)
            findNavController().navigate(action)
        })

    }
}


class RecommendRoutineAdapter(vm : RoutineListViewModel) : BaseRecyclerAdapter<RecommendRoutine, ItemRecommendRoutineListBinding>(
    R.layout.item_recommend_routine_list, vm
)