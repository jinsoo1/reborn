package com.reborn.reborn.ui.view.main.myPage.history

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.MyRoutineList
import com.reborn.reborn.databinding.FragmentHistoryBinding
import com.reborn.reborn.databinding.ItemListMyroutineBinding

class HistoryFragment : BaseVmFragment<FragmentHistoryBinding>(
    R.layout.fragment_history,
    HistoryViewModel::class.java
) {
    override val viewModel by lazy { vm as HistoryViewModel }

    override fun initFragment() {

        binding.apply {
            rvMyRoutine.apply {
                adapter = MyRoutineListAdapter(viewModel)
            }
        }
    }

}

class MyRoutineListAdapter(vm : HistoryViewModel) : BaseRecyclerAdapter<MyRoutineList, ItemListMyroutineBinding>(
    R.layout.item_list_myroutine, vm
){

}