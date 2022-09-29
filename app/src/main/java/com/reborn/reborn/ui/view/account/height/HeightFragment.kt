package com.reborn.reborn.ui.view.account.height

import android.util.Log
import android.view.View
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentHeightBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.picker.PickerAdapter
import com.reborn.reborn.ui.view.picker.PickerLayoutManager
import com.reborn.reborn.ui.view.picker.ScreenUtils
import com.reborn.reborn.util.EventObserver
import kotlinx.android.synthetic.main.fragment_height.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class HeightFragment: BaseVmFragment<FragmentHeightBinding>(
    R.layout.fragment_height,
    HeightViewModel::class.java
) {
    private val data = (0..250).toList()
        .map { it.toString() } as ArrayList<String>

    private lateinit var sliderAdapter: PickerAdapter

    override val viewModel by lazy { vm as HeightViewModel }

    private val activityViewModel by sharedViewModel<AccountViewModel>()

    override fun initFragment() {

        setPicker()

        viewModel.setObserves()

    }

    fun HeightViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                HeightViewModel.HeightActions.NEXT -> {
                    activityViewModel.switchPageHeight()
                    Log.d("다음", activityViewModel.nextState.value.toString())

                }
            }
        })
    }

    private fun setPicker(){

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(requireContext()) / 2 - ScreenUtils.dpToPx(requireContext(), 15)
        binding.rvHorizontalPicker.setPadding(padding, 0, padding, 0)

        // Setting layout manager
       binding.rvHorizontalPicker.layoutManager = PickerLayoutManager(requireContext()).apply {
           this.scrollToPosition(170)
            callback = object : PickerLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    sliderAdapter.setSelectedItem(layoutPosition)
                    Log.d("selected text", data[layoutPosition])
                    Log.d("selected text", layoutPosition.toString())

                }
            }
        }

        // Setting Adapter
        sliderAdapter = PickerAdapter()
        binding.rvHorizontalPicker.adapter = sliderAdapter.apply {
            setData(data)
            callback = object : PickerAdapter.Callback {
                override fun onItemClicked(view: View) {
                    binding.rvHorizontalPicker.smoothScrollToPosition(
                        binding.rvHorizontalPicker.getChildLayoutPosition(
                            view
                        )
                    )
                }
            }
        }
    }
}