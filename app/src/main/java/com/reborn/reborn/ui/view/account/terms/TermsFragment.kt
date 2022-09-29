package com.reborn.reborn.ui.view.account.terms

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentHeightBinding
import com.reborn.reborn.databinding.FragmentTermsBinding
import com.reborn.reborn.ui.view.account.height.HeightViewModel

class TermsFragment: BaseVmFragment<FragmentTermsBinding>(
    R.layout.fragment_terms,
    TermsViewModel::class.java
) {

    override val viewModel by lazy { vm as TermsViewModel }

    override fun initFragment() {}


}