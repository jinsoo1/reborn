package com.reborn.reborn.ui.view.myroutine.routinelist

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.RoutineList
import com.reborn.reborn.databinding.FragmentRoutineListBinding
import com.reborn.reborn.databinding.ItemMyroutineListBinding
import com.reborn.reborn.util.EventObserver

class RoutineListFragment : BaseVmFragment<FragmentRoutineListBinding>(
    R.layout.fragment_routine_list,
    RoutineListViewModel::class.java
) {
    override val viewModel by lazy { vm as RoutineListViewModel }

    override fun initFragment() {

        binding.apply {
            rvRoutine.apply {
                adapter = RoutineListAdapter(viewModel)
            }
        }

        viewModel.setObserves()

    }

    private fun RoutineListViewModel.setObserves(){
        actionData.observe(this@RoutineListFragment, EventObserver {

            val action = RoutineListFragmentDirections.actionRoutineListFragmentToExerciseListFragment(it.routineToken)
            findNavController().navigate(action)

        })
    }
}


class RoutineListAdapter(vm : RoutineListViewModel) : BaseRecyclerAdapter<RoutineList, ItemMyroutineListBinding>(
    R.layout.item_myroutine_list, vm
)