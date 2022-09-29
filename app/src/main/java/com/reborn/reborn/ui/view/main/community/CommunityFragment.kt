package com.reborn.reborn.ui.view.main.community

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentCommunityBinding
import com.reborn.reborn.ui.view.main.MainViewModel
import com.reborn.reborn.ui.view.main.search.SearchResultViewModel
import com.reborn.reborn.util.dialog.ReadyDialog
import com.reborn.reborn.util.dialog.setOnCloseClickListener
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CommunityFragment : BaseVmFragment<FragmentCommunityBinding>(
    R.layout.fragment_community,
    CommunityViewModel::class.java
) {
    override val viewModel by lazy { vm as CommunityViewModel }

    val activityViewModel by sharedViewModel<MainViewModel>()

    override fun initFragment() {

        binding.apply {
            tvClose.apply {
                setOnClickListener {
                    findNavController().navigate(R.id.action_global_home_fragment)
                    activityViewModel.actionIsHome()
                }
            }
        }


    }

}