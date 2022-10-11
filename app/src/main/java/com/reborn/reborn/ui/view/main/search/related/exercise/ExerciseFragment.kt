package com.reborn.reborn.ui.view.main.search.related.exercise

import android.os.Bundle
import android.view.View
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val youTubePlayerView = view.findViewById<YouTubeTest>(R.id.youtube)
        youTubePlayerView.play(VIDEO_ID)

    }



    companion object {
        fun newInstance() = ExerciseFragment()
        private const val VIDEO_ID = "DaHLR2WKsKI"
        private const val VIDEO_ID2 = "kBs9tYsyVCM"
    }

}