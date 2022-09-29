package com.reborn.reborn.ui.view.main.myPage

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentMypageBinding


class MyPageFragment : BaseVmFragment<FragmentMypageBinding>(
    R.layout.fragment_mypage,
    MyPageViewModel::class.java
) {
    override val viewModel by lazy { vm as MyPageViewModel }

    override fun initFragment() {

    }


}