package com.reborn.reborn.ui.view.main.search.related

import androidx.navigation.fragment.findNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.ActivityRelatedBinding
import com.reborn.reborn.ui.view.main.search.SearchResultViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class RelatedFragment : BaseVmFragment<ActivityRelatedBinding>(
    R.layout.activity_related,
    RelatedViewModel::class.java
) {
    override val viewModel by lazy { vm as RelatedViewModel }

    val activityViewModel by sharedViewModel<SearchResultViewModel>()

    override fun initFragment() {

        binding.exerciseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_relatedFragment_to_exerciseFragment)
            activityViewModel.setState(false)
            activityViewModel.setText(true)
        }

        binding.diseaseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_relatedFragment_to_diseaseFragment)
            activityViewModel.setState(false)
            activityViewModel.setText(false)
        }
    }

    override fun onResume() {
        super.onResume()
        activityViewModel.setState(true)

    }
}