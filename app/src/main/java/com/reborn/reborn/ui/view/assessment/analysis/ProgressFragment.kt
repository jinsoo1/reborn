package com.reborn.reborn.ui.view.assessment.analysis

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentAnalysisProgressBinding
import com.reborn.reborn.databinding.FragmentPurposeBinding
import com.reborn.reborn.ui.view.assessment.purpose.PurposeViewModel
import kotlinx.android.synthetic.main.fragment_analysis_progress.view.*
import org.jetbrains.anko.support.v4.runOnUiThread

class ProgressFragment: BaseVmFragment<FragmentAnalysisProgressBinding>(
    R.layout.fragment_analysis_progress,
    ProgressViewModel::class.java
) {

    override val viewModel by lazy { vm as ProgressViewModel }

    override fun initFragment() {

        var progress = 0
        Thread(Runnable {
            while (progress < 100){
                progress += 1

                runOnUiThread {
                    binding.progressBar.progress = progress
                    if (progress == 10){
                        binding.tvProgress.text = "안녕하세요. 홍길동님"
                    } else if (progress == 30){
                        binding.tvProgress.text = "내용을 분석 중입니다"
                    }
                    else if (progress == 60){
                        binding.tvProgress.text = "맞춤 운동을 찾는 중입니다."
                    }
                    else if (progress == 90){
                        binding.tvProgress.text = "홍길동님의 맞춤 운동 완료"
                    }

                }
                Thread.sleep(90)
            }
        }).start()

    }

}