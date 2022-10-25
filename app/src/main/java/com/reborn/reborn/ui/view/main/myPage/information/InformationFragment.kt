package com.reborn.reborn.ui.view.main.myPage.information

import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentInformationBinding
import com.reborn.reborn.util.EventObserver

class InformationFragment : BaseVmFragment<FragmentInformationBinding>(
    R.layout.fragment_information,
    InformationViewModel::class.java
){
    override val viewModel by lazy { vm as InformationViewModel }

    override fun initFragment() {


        viewModel.setObserves()

    }


    private fun InformationViewModel.setObserves(){

        action.observe(this@InformationFragment, EventObserver{
            when(it){
                InformationViewModel.InformationAction.GENDER ->{
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("성별선택")
                        .setMessage("성별을 선택해주세요.")
                        .setNegativeButton("남자"){ dialog, _ ->

                        }
                        .setPositiveButton("여자") { dialog, _ ->

                        }
                        .show()
                }
            }
        })

    }

}