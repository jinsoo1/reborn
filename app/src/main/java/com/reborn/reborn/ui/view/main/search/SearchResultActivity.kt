package com.reborn.reborn.ui.view.main.search

import androidx.lifecycle.Observer
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivitySearchresultBinding
import com.reborn.reborn.ui.view.main.search.related.exercise.ExerciseFragment


class SearchResultActivity : BaseVmActivity<ActivitySearchresultBinding>(
    R.layout.activity_searchresult,
    SearchResultViewModel::class.java
){
    override val viewModel by lazy { vm as SearchResultViewModel }
    override val toolbarId = 0

    override fun initActivity() {


        viewModel.setObserves()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ExerciseFragment.newInstance())
            .commitNow()

    }

    private fun SearchResultViewModel.setObserves(){


        setText.observe(this@SearchResultActivity, Observer {
            when(it){
                true -> binding.tvTitle.text = getString(R.string.exercise_name)

                false -> binding.tvTitle.text = getString(R.string.disease)
            }
        })
    }

}