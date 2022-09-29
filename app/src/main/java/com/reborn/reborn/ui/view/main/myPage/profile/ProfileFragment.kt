package com.reborn.reborn.ui.view.main.myPage.profile

import android.util.Log
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentProfileBinding
import com.reborn.reborn.util.EventObserver
import com.reborn.reborn.util.dialog.ReadyDialog
import com.reborn.reborn.util.dialog.setOnCloseClickListener

class ProfileFragment : BaseVmFragment<FragmentProfileBinding>(
    R.layout.fragment_profile,
    ProfileViewModel::class.java
) {
    override val viewModel by lazy { vm as ProfileViewModel }

    override fun initFragment() {



        viewModel.setObserves()

    }


    private fun ProfileViewModel.setObserves(){

        action.observe(this@ProfileFragment, EventObserver{
            when(it){
                ProfileViewModel.ProfileAction.Edit ->{

                    val dialog = ReadyDialog()
                    dialog.show(requireActivity().supportFragmentManager, "")

                }
            }

        })


    }

}