package com.reborn.reborn.ui.view.myroutine.feedback

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentFeedbackBinding
import com.reborn.reborn.ui.view.myroutine.feedback.dialog.FeedbackContinueDialog
import com.reborn.reborn.ui.view.myroutine.feedback.dialog.setOnContinueListener
import com.reborn.reborn.util.EventObserver
import org.jetbrains.anko.support.v4.toast

class FeedbackFragment : BaseVmFragment<FragmentFeedbackBinding>(
    R.layout.fragment_feedback,
    FeedbackViewModel::class.java
) {
    override val viewModel by lazy { vm as FeedbackViewModel }

    override fun initFragment() {


        viewModel.setObserves()

    }

    private fun FeedbackViewModel.setObserves(){
        action.observe(this@FeedbackFragment, EventObserver{
            when(it){
                FeedbackViewModel.ShowDialog.SHOW ->{
                    val listener = object : setOnContinueListener{
                        override fun continueClick() {
                            findNavController().navigate(R.id.action_feedbackFragment_to_completeRoutineFragment)
                        }

                        override fun homeClick() {
                            requireActivity().finish()
                        }

                    }

                    val dialog = FeedbackContinueDialog(listener)
                    dialog.show(requireActivity().supportFragmentManager, "")


                }
            }
        })

    }
}