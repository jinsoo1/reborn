package com.reborn.reborn.ui.view.assessment.rehab

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentCodeBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeFragmentDirections
import com.reborn.reborn.util.EventObserver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

                    if (typeState.value == true){ //없음
                        activityViewModel.diseaseCodeData.value = "없음"
                        val action = CodeFragmentDirections.actionCodeFragmentToSpotFragment()
                        findNavController().navigate(action)
                    } else {
                        activityViewModel.diseaseCodeData.value = binding.etCode.text.toString()
                        Log.d("테스트", "codeData : "+binding.etCode.text.toString())
                        val action = CodeFragmentDirections.actionCodeFragmentToSpotFragment()
                        findNavController().navigate(action)
                    }
                }
                CodeViewModel.CodeActions.PREV -> {
                    requireActivity().onBackPressed()
                }
                CodeViewModel.CodeActions.NONE -> {
                    binding.btnNone.setBackgroundResource(R.drawable.back_primary_radius_5dp)
                    binding.btnNone.setTextColor(Color.WHITE)
                    typeState.value = true
                    hideKeyboard()

                }
                CodeViewModel.CodeActions.STOP -> {
                    activityViewModel.finish()
                }
                CodeViewModel.CodeActions.CODEINPUT -> {
                    binding.btnNone.setBackgroundResource(R.drawable.back_stroke_radius_5dp)
                    binding.btnNone.setTextColor(ContextCompat.getColor(requireContext(), R.color.second_primary))
                    typeState.value = false
                }

            }
        })

        codeText.observe(this@CodeFragment, Observer {
            binding.btnNone.setBackgroundResource(R.drawable.back_stroke_radius_5dp)
            binding.btnNone.setTextColor(ContextCompat.getColor(requireContext(), R.color.second_primary))
            typeState.value = false
        })

        typeState.observe(this@CodeFragment, Observer {
            btnState.value = !(!it && codeText.value?.length == 0)
        })

        btnState.observe(this@CodeFragment, Observer {
            binding.btnNext.isEnabled = it
        })
    }

    fun hideKeyboard(){
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.etCode.windowToken, 0)
    }



}