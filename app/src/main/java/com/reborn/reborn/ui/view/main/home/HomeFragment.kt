package com.reborn.reborn.ui.view.main.home

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.TodayBestExercise
import com.reborn.reborn.data.common.model.TodayBestFeed
import com.reborn.reborn.databinding.FragmentHomeBinding
import com.reborn.reborn.databinding.ItemBestExerciseBinding
import com.reborn.reborn.databinding.ItemBestFeedBinding
import com.reborn.reborn.ui.view.myroutine.MyRoutineActivity
import org.jetbrains.anko.support.v4.intentFor

class HomeFragment : BaseVmFragment<FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {
    override val viewModel by lazy { vm as HomeViewModel }

    override fun initFragment() {


        binding.apply {
            rvBestExercise.apply {
                adapter = TodayBestExerciseAdapter(viewModel)
            }

            rvBestFeed.apply {
                adapter = TodayBestFeedAdapter(viewModel)
            }

            testLayout.apply {
                setOnClickListener {
                    startActivity(
                        intentFor<MyRoutineActivity>()
                    )
                }
            }
        }



    }

}


class TodayBestExerciseAdapter(vm : HomeViewModel) : BaseRecyclerAdapter<TodayBestExercise, ItemBestExerciseBinding>(
            R.layout.item_best_exercise, vm
)

class TodayBestFeedAdapter(vm : HomeViewModel): BaseRecyclerAdapter<TodayBestFeed, ItemBestFeedBinding>(
            R.layout.item_best_feed, vm
)

