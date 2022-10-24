package com.reborn.reborn.ui.view.assessment.analysis

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityAnalysisProgressBinding
import com.reborn.reborn.ui.view.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast

class ProgressActivity : BaseVmActivity<ActivityAnalysisProgressBinding>(
    R.layout.activity_analysis_progress,
    ProgressViewModel::class.java
){
    override val viewModel : ProgressViewModel by lazy { vm as ProgressViewModel }

    override val toolbarId = 0

    override fun initActivity() {
        var progress = 0

        lifecycleScope.launch{
            while(progress < 100){
                progress ++
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
                } else if(progress == 100) {
                    val intent = Intent(this@ProgressActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                if(progress < 10) delay(20) else if(progress in 10..30) delay(70) else if(progress in 30..60) delay(100) else if(progress in 60..100) delay(15)

            }


        }
    }

    override fun onBackPressed() {
        toast("분석중입니다. 잠시만 기다려주세요.")
    }


}