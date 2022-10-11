package com.reborn.reborn.ui.view.assessment.rehab

import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentCodeBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeFragmentDirections
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CodeFragment: BaseVmFragment<FragmentCodeBinding>(
    R.layout.fragment_code,
    CodeViewModel::class.java
) {

    override val viewModel by lazy { vm as CodeViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()

    val typeState: MutableLiveData<Boolean> = MutableLiveData(false) //true이면 없음, false이면 있음

    override fun initFragment() {

        viewModel.setObserves()

    }

    fun CodeViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                CodeViewModel.CodeActions.NEXT -> {

                    if (typeState.value == true){ //없음
                        activityViewModel.codeData.value = "없음"
                        val action = CodeFragmentDirections.actionCodeFragmentToSpotFragment()
                        findNavController().navigate(action)
                    } else {
                        activityViewModel.codeData.value = binding.etCode.text.toString()
                        Log.d("테스트", "codeData : "+binding.etCode.text.toString())
                        val action = CodeFragmentDirections.actionCodeFragmentToSpotFragment()
                        findNavController().navigate(action)
                    }
                }
                CodeViewModel.CodeActions.PREV -> {
                    activityViewModel.codePrev()
                }
                CodeViewModel.CodeActions.NONE -> {
                    binding.btnNone.setBackgroundResource(R.drawable.back_primary_radius_5dp)
                    binding.btnNone.setTextColor(Color.WHITE)
                    typeState.value = true

                }
                CodeViewModel.CodeActions.STOP -> {
                    activityViewModel.finish()
                }
                CodeViewModel.CodeActions.CODEINPUT -> {
                    binding.btnNone.setBackgroundResource(R.drawable.back_stroke_radius_5dp)
                    binding.btnNone.setTextColor(ContextCompat.getColor(requireContext()!!, R.color.second_primary))
                }

            }
        })
    }

}