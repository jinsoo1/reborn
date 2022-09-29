package com.reborn.reborn.ui.view.assessment.rehab

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentCodeBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CodeFragment: BaseVmFragment<FragmentCodeBinding>(
    R.layout.fragment_code,
    CodeViewModel::class.java
) {

    override val viewModel by lazy { vm as CodeViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun CodeViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                CodeViewModel.CodeActions.NEXT -> {
                    activityViewModel.codeNext()
                }
                CodeViewModel.CodeActions.PREV -> {
                    activityViewModel.codePrev()
                }
                CodeViewModel.CodeActions.NONE -> {
                    activityViewModel.clickNone()
                }
                CodeViewModel.CodeActions.STOP -> {
                    activityViewModel.finish()
                }

            }
        })
    }

}