package com.reborn.reborn.ui.view.main.search.related.disease

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityDiseaseBinding

class DiseaseActivity : BaseVmActivity<ActivityDiseaseBinding>(
    R.layout.activity_disease,
    DiseaseViewModel::class.java
) {
    override val viewModel by lazy { vm as DiseaseViewModel }
    override val toolbarId = 0

    val title: String? by lazy {
        intent.getStringExtra("title")
    }
    val token: String? by lazy {
        intent.getStringExtra("token")
    }

    override fun initActivity() {

        binding.apply {
            tvDisease.text = "$title($token)"
        }
    }
}