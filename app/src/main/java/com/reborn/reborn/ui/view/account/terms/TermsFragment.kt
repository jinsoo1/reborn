package com.reborn.reborn.ui.view.account.terms

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentHeightBinding
import com.reborn.reborn.databinding.FragmentTermsBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.account.height.HeightViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class TermsFragment: BaseVmFragment<FragmentTermsBinding>(
    R.layout.fragment_terms,
    TermsViewModel::class.java
) {

    override val viewModel by lazy { vm as TermsViewModel }

    private val activityViewModel by sharedViewModel<AccountViewModel>()

    override fun initFragment() {


        viewModel.setObserves()

    }


    fun TermsViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            activityViewModel.setTerms(1)
        })

    }


}