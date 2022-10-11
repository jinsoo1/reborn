package com.reborn.reborn.ui.view.assessment

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.kakao.sdk.common.util.Utility
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityAssessmentBinding
import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.assessment.analysis.ProgressFragment
import com.reborn.reborn.ui.view.assessment.purpose.PurposeFragment
import com.reborn.reborn.ui.view.assessment.rehab.CodeFragment
import com.reborn.reborn.ui.view.assessment.rehab.SpotFragment
import com.reborn.reborn.ui.view.assessment.rehab.SpotLocationFragment
import com.reborn.reborn.ui.view.assessment.vas.DynamicFragment
import com.reborn.reborn.ui.view.assessment.vas.StaticFragment
import com.reborn.reborn.ui.view.main.MainActivity
import com.reborn.reborn.util.EventObserver
import com.reborn.reborn.util.FragmentUtils
import com.reborn.reborn.util.KeepStateNavigator

class AssessmentActivity: BaseVmActivity<ActivityAssessmentBinding>(
    R.layout.activity_assessment,
    AssessmentViewModel::class.java
) {

    override val viewModel: AssessmentViewModel by lazy { vm as AssessmentViewModel }
    override val toolbarId: Int = 0


//    private val purposeFragment: PurposeFragment by lazy { PurposeFragment() }
//    private val codeFragment: CodeFragment by lazy { CodeFragment() }
//    private val spotFragment: SpotFragment by lazy { SpotFragment() }
//    private val spotLocationFragment: SpotLocationFragment by lazy { SpotLocationFragment() }
//    private val staticFragment: StaticFragment by lazy { StaticFragment() }
//    private val dynamicFragment: DynamicFragment by lazy { DynamicFragment() }
//    private val progressFragment: ProgressFragment by lazy { ProgressFragment() }
//
//    private val fragments: FragmentUtils by lazy {
//        FragmentUtils(
//            R.id.fragment_container,
//            supportFragmentManager,
//            arrayOf(
//                progressFragment,
//                purposeFragment,
//                codeFragment,
//                spotFragment,
//                spotLocationFragment,
//                staticFragment,
//                dynamicFragment
//
//            )
//        )
//    }


    override fun initActivity() {

        val navHostFragment = supportFragmentManager.findFragmentById(binding.navHostAssessment.id) as NavHostFragment
        val navController = navHostFragment.navController

        val navigator = KeepStateNavigator(this, navHostFragment.childFragmentManager, binding.navHostAssessment.id)
        navController.navigatorProvider.addNavigator(navigator)

        navController.setGraph(R.navigation.nav_graph_assessment)

//        switchPage(0)

        var keyHash = Utility.getKeyHash(this)
        Log.d("키해시", keyHash.toString())

        viewModel.setObserves()

    }

    fun AssessmentViewModel.setObserves(){

        action.observe(this@AssessmentActivity, EventObserver{
            when(it) {

                AssessmentViewModel.AssessmentAction.CODEPREV -> {

                }
                AssessmentViewModel.AssessmentAction.CODENEXT -> {

                }
                AssessmentViewModel.AssessmentAction.CLICK_NONE -> {

                }
                AssessmentViewModel.AssessmentAction.SPOTPREV -> {

                }
                AssessmentViewModel.AssessmentAction.LOCATIONPREV -> {

                }
                AssessmentViewModel.AssessmentAction.STATICPREV -> {
                    //메인액티비티로 이동

                }
                AssessmentViewModel.AssessmentAction.DYNAMICPREV -> {
                    //메인액티비티로 이동

                }
                AssessmentViewModel.AssessmentAction.FINISH -> {
                    //메인액티비티로 이동
                    val intent = Intent(this@AssessmentActivity, MainActivity::class.java)
                    startActivity(intent)
                }


            }
        })
    }

//    private fun switchPage(pageIndex: Int) {
//        if (pageIndex < fragments.fragmentCount) {
//
//            fragments.setCurrentFragmentByPosition(pageIndex)
//        }
//    }

}