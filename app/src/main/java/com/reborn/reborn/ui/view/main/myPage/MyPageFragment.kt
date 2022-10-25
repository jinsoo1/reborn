package com.reborn.reborn.ui.view.main.myPage

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.data.local.pref.PreferencesController
import com.reborn.reborn.databinding.FragmentMypageBinding
import com.reborn.reborn.ui.view.login.LoginActivity
import com.reborn.reborn.util.EventObserver
import org.jetbrains.anko.support.v4.intentFor


class MyPageFragment : BaseVmFragment<FragmentMypageBinding>(
    R.layout.fragment_mypage,
    MyPageViewModel::class.java
) {
    override val viewModel by lazy { vm as MyPageViewModel }

    override fun initFragment() {

        viewModel.setObserves()

    }

    private fun MyPageViewModel.setObserves(){

        action.observe(this@MyPageFragment, EventObserver{
            when(it){
                MyPageViewModel.MyPageAction.LOGOUT ->{
                    PreferencesController.userInfoPref.clearPref()
                    startActivity(
                        intentFor<LoginActivity>()
                    )
                    requireActivity().finish()
                }
            }


        })

    }


}