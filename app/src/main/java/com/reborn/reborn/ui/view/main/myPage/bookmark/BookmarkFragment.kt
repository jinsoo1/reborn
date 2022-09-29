package com.reborn.reborn.ui.view.main.myPage.bookmark

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentBookmarkBinding

class BookmarkFragment : BaseVmFragment<FragmentBookmarkBinding>(
    R.layout.fragment_bookmark,
    BookmarkViewModel::class.java
) {
    override val viewModel by lazy { vm as BookmarkViewModel }

    override fun initFragment() {
    }

}