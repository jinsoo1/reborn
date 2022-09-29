package com.reborn.reborn.ui.view.main.myPage.information

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseViewModel
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentInformationBinding

class InformationFragment : BaseVmFragment<FragmentInformationBinding>(
    R.layout.fragment_information,
    InformationViewModel::class.java
){
    override val viewModel by lazy { vm as InformationViewModel }

    override fun initFragment() {

    }

}