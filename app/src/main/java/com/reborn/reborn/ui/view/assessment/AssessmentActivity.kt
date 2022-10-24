package com.reborn.reborn.ui.view.assessment

import android.util.Log
import com.kakao.sdk.common.util.Utility
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityAssessmentBinding
import com.reborn.reborn.ui.view.assessment.analysis.ProgressActivity
import com.reborn.reborn.ui.view.main.MainActivity
import com.reborn.reborn.util.EventObserver
import org.jetbrains.anko.intentFor

class AssessmentActivity: BaseVmActivity<ActivityAssessmentBinding>(
    R.layout.activity_assessment,
    AssessmentViewModel::class.java
) {

    override val viewModel: AssessmentViewModel by lazy { vm as AssessmentViewModel }
    override val toolbarId: Int = 0

    override fun initActivity() {

        var keyHash = Utility.getKeyHash(this)
        Log.d("키해시", keyHash.toString())

        viewModel.setObserves()

    }

    fun AssessmentViewModel.setObserves(){

        action.observe(this@AssessmentActivity, EventObserver{
            when(it) {
                AssessmentViewModel.AssessmentAction.FINISH -> {

                    startActivity(
                        intentFor<MainActivity>()
                    )
                    this@AssessmentActivity.finish()
                }

                AssessmentViewModel.AssessmentAction.COMPLETE -> {
                    setPain()
                }

                AssessmentViewModel.AssessmentAction.PROGRESS ->{
                    startActivity(
                        intentFor<ProgressActivity>()
                    )
                    this@AssessmentActivity.finish()
                }

            }
        })
    }
}