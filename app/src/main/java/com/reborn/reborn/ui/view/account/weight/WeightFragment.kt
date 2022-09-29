package com.reborn.reborn.ui.view.account.weight

import android.util.Log
import android.view.View
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentWeightBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.picker.PickerAdapterWeight
import com.reborn.reborn.ui.view.picker.PickerLayoutManager
import com.reborn.reborn.ui.view.picker.ScreenUtils
import com.reborn.reborn.util.EventObserver
import kotlinx.android.synthetic.main.fragment_height.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class WeightFragment : BaseVmFragment<FragmentWeightBinding>(
    R.layout.fragment_weight,
    WeightViewModel::class.java
) {

    private val data = (0..200).toList()
        .map { it.toString() } as ArrayList<String>

    private lateinit var sliderAdapter: PickerAdapterWeight

    override val viewModel by lazy { vm as WeightViewModel }
    private val activityViewModel by sharedViewModel<AccountViewModel>()

    override fun initFragment() {

        setPicker()

//        /*
//         * for the below picker
//         * */
//
//        numberPicker.value = 170
//        numberPicker.minValue = 0
//        numberPicker.setMaxValue(24)

        viewModel.setObserves()

    }

    fun WeightViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                WeightViewModel.WeightActions.NEXT -> {
                    activityViewModel.switchPageWeight()
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
            this.scrollToPosition(60)
            callback = object : PickerLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    sliderAdapter.setSelectedItem(layoutPosition)
                    Log.d("selected text", data[layoutPosition])

                }
            }
        }

        // Setting Adapter
        sliderAdapter = PickerAdapterWeight()
        binding.rvHorizontalPicker.adapter = sliderAdapter.apply {
            setData(data)
            callback = object : PickerAdapterWeight.Callback {
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