package com.reborn.reborn.ui.view.main.myPage

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentMypageNavBinding
import com.reborn.reborn.util.EventObserver

class MyPageNavFragment : BaseVmFragment<FragmentMypageNavBinding>(
    R.layout.fragment_mypage_nav,
    MyPageNavViewModel::class.java
){
    override val viewModel by lazy { vm as MyPageNavViewModel }

    override fun initFragment() {


        viewModel.setObserves()

    }


    private fun MyPageNavViewModel.setObserves(){

        action.observe(this@MyPageNavFragment, EventObserver{
            when(it){
                MyPageNavViewModel.NavPageAction.PROFILE ->{
                    findNavController().navigate(R.id.action_myPageNavFragment_to_profileFragment)
                }

                MyPageNavViewModel.NavPageAction.INFORMATION ->{
                    findNavController().navigate(R.id.action_myPageNavFragment_to_informationFragment)
                }

                MyPageNavViewModel.NavPageAction.BOOKMARK ->{
                    findNavController().navigate(R.id.action_myPageNavFragment_to_bookmarkFragment)
                }

                MyPageNavViewModel.NavPageAction.HISTORY ->{
                    findNavController().navigate(R.id.action_myPageNavFragment_to_historyFragment)
                }
            }
        })

    }
}