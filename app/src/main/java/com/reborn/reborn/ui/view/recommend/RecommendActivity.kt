package com.reborn.reborn.ui.view.recommend

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityRecommendBinding

class RecommendActivity : BaseVmActivity<ActivityRecommendBinding>(
    R.layout.activity_recommend,
    RecommendViewModel::class.java
) {
    override val viewModel : RecommendViewModel by lazy{ vm as RecommendViewModel }
    override val toolbarId = 0

    override fun initActivity() {




    }
}