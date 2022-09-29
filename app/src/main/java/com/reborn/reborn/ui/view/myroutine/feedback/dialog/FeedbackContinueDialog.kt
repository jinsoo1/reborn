package com.reborn.reborn.ui.view.myroutine.feedback.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.reborn.reborn.R
import com.reborn.reborn.databinding.DialogFeedbackcontinueBinding

class FeedbackContinueDialog(listener: setOnContinueListener) : DialogFragment() {

    private lateinit var binding : DialogFeedbackcontinueBinding
    private var listener = listener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isCancelable = true
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_feedbackcontinue, null, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        binding.tvContinue.setOnClickListener {

            listener.continueClick()
            dismiss()

        }

        binding.tvHome.setOnClickListener {

            listener.homeClick()
            dismiss()
        }

    }

}