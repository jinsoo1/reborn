package com.reborn.reborn.ui.view.main.search.related.exercise

import androidx.recyclerview.widget.LinearLayoutManager
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityExerciseBinding
import androidx.lifecycle.Observer
import java.util.*

class ExerciseActivity : BaseVmActivity<ActivityExerciseBinding>(
    R.layout.activity_exercise,
    ExerciseViewModel::class.java
){
    override val viewModel by lazy { vm as ExerciseViewModel }
    override val toolbarId = 0

    val title: String? by lazy {
        intent.getStringExtra("title")
    }
    val token: String? by lazy {
        intent.getStringExtra("token")
    }

    var youtubeVideos: Vector<YouTubeVideos> = Vector<YouTubeVideos>()

    override fun initActivity() {

        viewModel.setToken(token!!)

        viewModel.setObserves()

    }

    fun ExerciseViewModel.setObserves(){


        exerciseToken.observe(this@ExerciseActivity, Observer {
            detailExercise()
        })

        detailExercise.observe(this@ExerciseActivity, Observer {
            binding.apply {
                rvVideos.hasFixedSize()
                rvVideos.layoutManager = LinearLayoutManager(this@ExerciseActivity)

                youtubeVideos.add( YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/${it.video}\" frameborder=\"0\" allowfullscreen></iframe>"))
                youtubeVideos.add( YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/${it.videoExplain}\" frameborder=\"0\" allowfullscreen></iframe>"))

                val videoAdapter = VideoAdapter(youtubeVideos)

                rvVideos.adapter = videoAdapter

                tvExercise.text = title

            }
        })

    }

}