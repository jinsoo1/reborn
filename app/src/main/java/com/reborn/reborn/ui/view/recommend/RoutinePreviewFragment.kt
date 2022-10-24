package com.reborn.reborn.ui.view.recommend

import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.common.model.RoutineExerciseList
import com.reborn.reborn.databinding.FragmentRecommendRoutinePreviewBinding
import com.reborn.reborn.databinding.ItemRoutineExerciseBinding
import com.reborn.reborn.ui.view.main.search.related.exercise.ExerciseActivity
import com.reborn.reborn.util.EventObserver
import kotlinx.android.synthetic.main.item_routine_exercise.view.*
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast

class RoutinePreviewFragment : BaseVmFragment<FragmentRecommendRoutinePreviewBinding>(
    R.layout.fragment_recommend_routine_preview,
    RoutinePreviewViewModel::class.java
) {
    override val viewModel : RoutinePreviewViewModel by lazy { vm as RoutinePreviewViewModel }

    val args : RoutinePreviewFragmentArgs by navArgs()

    override fun initFragment() {

        viewModel.routineToken.value = args.routineToken

        viewModel.setObserves()

        binding.apply {
            rvExercise.apply {
                adapter = RoutineExerciseAdapter(viewModel)
            }
        }

    }

    private fun RoutinePreviewViewModel.setObserves(){

        routineToken.observe(this@RoutinePreviewFragment, Observer {
            exerciseList()
        })

        selectedPreview.observe(viewLifecycleOwner, EventObserver{
            startActivity(
                intentFor<ExerciseActivity>(
                    "title" to it.exerciseName,
                    "token" to it.exerciseToken
                )
            )
        })

    }
}

class RoutineExerciseAdapter(vm : RoutinePreviewViewModel) : BaseRecyclerAdapter<RoutineExerciseList, ItemRoutineExerciseBinding>(
    R.layout.item_routine_exercise, vm
){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val number = position+1
        holder.binding.root.tv_position.text = "$number."

    }
}