package com.reborn.reborn.ui.view.myroutine.complete

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.ExerciseList
import com.reborn.reborn.databinding.FragmentCompleteBinding
import com.reborn.reborn.databinding.ItemCompleteExerciseBinding
import com.reborn.reborn.util.EventObserver

class CompleteFragment : BaseVmFragment<FragmentCompleteBinding>(
    R.layout.fragment_complete,
    CompleteViewModel::class.java
) {
    override val viewModel by lazy { vm as CompleteViewModel }

    private val args by navArgs<CompleteFragmentArgs>()

    override fun initFragment() {
        viewModel.routineToken.value = args.routineToken


        binding.apply {
            rvCompleteExercise.apply {
                adapter = CompleteExerciseAdapter(viewModel)
            }
        }

        viewModel.setObserves()

    }


    private fun CompleteViewModel.setObserves(){

        actionData.observe(this@CompleteFragment, EventObserver{
            when(it){
                CompleteViewModel.CompleteStart.START ->{
                    val action = CompleteFragmentDirections.actionCompleteFragmentToFeedbackFragment(
                        args.routineToken
                    )
                    findNavController().navigate(action)
                }
            }
        })

    }

}

class CompleteExerciseAdapter(vm : CompleteViewModel) : BaseRecyclerAdapter<ExerciseList, ItemCompleteExerciseBinding>(
    R.layout.item_complete_exercise, vm
){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        (holder.binding as ItemCompleteExerciseBinding).apply {

            val position = (position + 1).toString()
            tvPosition.text = "$position. "

        }
    }
}