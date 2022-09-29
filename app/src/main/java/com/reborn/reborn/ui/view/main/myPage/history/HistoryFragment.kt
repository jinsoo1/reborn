package com.reborn.reborn.ui.view.main.myPage.history

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentHistoryBinding

class HistoryFragment : BaseVmFragment<FragmentHistoryBinding>(
    R.layout.fragment_history,
    HistoryViewModel::class.java
) {
    override val viewModel by lazy { vm as HistoryViewModel }

    override fun initFragment() {
    }

}