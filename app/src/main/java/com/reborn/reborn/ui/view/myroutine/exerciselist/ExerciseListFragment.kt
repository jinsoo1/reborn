package com.reborn.reborn.ui.view.myroutine.exerciselist

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.App.Companion.toast
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.databinding.FragmentExerciseListBinding
import com.reborn.reborn.databinding.ItemMyexerciseListBinding
import com.reborn.reborn.ui.view.myroutine.routinelist.RoutineListFragmentDirections
import com.reborn.reborn.util.EventObserver

class ExerciseListFragment : BaseVmFragment<FragmentExerciseListBinding>(
    R.layout.fragment_exercise_list,
    ExerciseListViewModel::class.java
) {
    override val viewModel by lazy { vm as ExerciseListViewModel }

    private val args by navArgs<ExerciseListFragmentArgs>()

    override fun initFragment() {
        Log.d("routineToken", "initFragment")


        viewModel.routineToken.value = args.routineToken

        binding.apply {
            rvRoutine.apply {
                adapter = ExerciseListAdapter(viewModel)
            }
        }


        viewModel.setObserves()

    }


    private fun ExerciseListViewModel.setObserves(){

        actionData.observe(this@ExerciseListFragment, EventObserver{
            when(it){
                ExerciseListViewModel.ExerciseStart.START ->{
                    val action = ExerciseListFragmentDirections.actionExerciseListFragmentToCompleteFragment(
                        args.routineToken
                    )
                    findNavController().navigate(action)
                }
            }
        })

    }

}


class ExerciseListAdapter(vm : ExerciseListViewModel) : BaseRecyclerAdapter<ExerciseList, ItemMyexerciseListBinding>(
    R.layout.item_myexercise_list, vm
){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        (holder.binding as ItemMyexerciseListBinding).apply {
            val positions = (position + 1).toString()
            tvPosition.text = "$positions. "


        }
    }
}