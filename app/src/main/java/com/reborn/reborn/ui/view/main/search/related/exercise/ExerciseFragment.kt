package com.reborn.reborn.ui.view.main.search.related.exercise

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentExerciseBinding

class ExerciseFragment : BaseVmFragment<FragmentExerciseBinding>(
    R.layout.fragment_exercise,
    ExerciseViewModel::class.java
) {
    override val viewModel by lazy { vm as ExerciseViewModel }

    override fun initFragment() {
    }

}