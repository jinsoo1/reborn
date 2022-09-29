package com.reborn.reborn.ui.view.assessment

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityAssessmentBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeFragment
import com.reborn.reborn.ui.view.assessment.rehab.CodeFragment
import com.reborn.reborn.ui.view.assessment.rehab.SpotFragment
import com.reborn.reborn.ui.view.assessment.rehab.SpotLocationFragment
import com.reborn.reborn.ui.view.assessment.vas.DynamicFragment
import com.reborn.reborn.ui.view.assessment.vas.StaticFragment
import com.reborn.reborn.ui.view.main.MainActivity
import com.reborn.reborn.util.EventObserver
import com.reborn.reborn.util.FragmentUtils

class AssessmentActivity: BaseVmActivity<ActivityAssessmentBinding>(
    R.layout.activity_assessment,
    AssessmentViewModel::class.java
) {

    override val viewModel: AssessmentViewModel by lazy { vm as AssessmentViewModel }

    override val toolbarId: Int = 0

    private val purposeFragment: PurposeFragment by lazy { PurposeFragment() }
    private val codeFragment: CodeFragment by lazy { CodeFragment() }
    private val spotFragment: SpotFragment by lazy { SpotFragment() }
    private val spotLocationFragment: SpotLocationFragment by lazy { SpotLocationFragment() }
    private val staticFragment: StaticFragment by lazy { StaticFragment() }
    private val dynamicFragment: DynamicFragment by lazy { DynamicFragment() }

    private val fragments: FragmentUtils by lazy {
        FragmentUtils(
            R.id.fragment_container,
            supportFragmentManager,
            arrayOf(
                purposeFragment,
                codeFragment,
                spotFragment,
                spotLocationFragment,
                staticFragment,
                dynamicFragment
            )
        )
    }


    override fun initActivity() {

        switchPage(0)

        viewModel.setObserves()

    }

    fun AssessmentViewModel.setObserves(){

        action.observe(this@AssessmentActivity, EventObserver{
            when(it) {
                AssessmentViewModel.AssessmentAction.CLICK_REHAB -> {
                    switchPage(1)
                }
                AssessmentViewModel.AssessmentAction.CLICK_MUSCLE -> {
                    switchPage(1)
                }
                AssessmentViewModel.AssessmentAction.CLICK_CORRECT -> {
                    switchPage(1)
                }
                AssessmentViewModel.AssessmentAction.CODEPREV -> {
                    switchPage(0)
                }
                AssessmentViewModel.AssessmentAction.CODENEXT -> {
                    switchPage(2)
                }
                AssessmentViewModel.AssessmentAction.CLICK_NONE -> {
                    switchPage(2)
                }
                AssessmentViewModel.AssessmentAction.SPOTPREV -> {
                    switchPage(1)
                }
                AssessmentViewModel.AssessmentAction.LOCATIONPREV -> {
                    switchPage(1)
                }
                AssessmentViewModel.AssessmentAction.STATICPREV -> {
                    //메인액티비티로 이동
                    switchPage(2)
                }
                AssessmentViewModel.AssessmentAction.DYNAMICPREV -> {
                    //메인액티비티로 이동
                    switchPage(3)
                }
                AssessmentViewModel.AssessmentAction.FINISH -> {
                    //메인액티비티로 이동
                    val intent = Intent(this@AssessmentActivity, MainActivity::class.java)
                    startActivity(intent)
                }


            }
        })
    }

    private fun switchPage(pageIndex: Int) {
        if (pageIndex < fragments.fragmentCount) {

            fragments.setCurrentFragmentByPosition(pageIndex)
        }
    }

}