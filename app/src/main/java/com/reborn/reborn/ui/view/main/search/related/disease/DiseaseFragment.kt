package com.reborn.reborn.ui.view.main.search.related.disease

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentDiseaseBinding

class DiseaseFragment : BaseVmFragment<FragmentDiseaseBinding>(
    R.layout.fragment_disease,
    DiseaseViewModel::class.java
) {
    override val viewModel by lazy { vm as DiseaseViewModel }

    override fun initFragment() {

    }
}