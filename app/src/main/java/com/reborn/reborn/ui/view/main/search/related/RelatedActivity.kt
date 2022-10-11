package com.reborn.reborn.ui.view.main.search.related

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityRelatedBinding
import com.reborn.reborn.ui.view.main.search.related.exercise.ExerciseFragment

class RelatedActivity : BaseVmActivity<ActivityRelatedBinding>(
    R.layout.activity_related,
    RelatedViewModel::class.java
) {
    override val viewModel by lazy {
        vm as RelatedViewModel
    }

    override val toolbarId = 0

    override fun initActivity() {

        binding.exerciseBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ExerciseFragment.newInstance())
                .commitNow()

        }

    }
}