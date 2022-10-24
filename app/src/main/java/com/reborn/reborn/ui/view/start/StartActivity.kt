package com.reborn.reborn.ui.view.start

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityStartBinding
import com.reborn.reborn.ui.view.account.AccountActivity
import com.reborn.reborn.ui.view.assessment.AssessmentActivity
import com.reborn.reborn.ui.view.login.LoginActivity
import com.reborn.reborn.ui.view.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.intentFor

class StartActivity : BaseVmActivity<ActivityStartBinding>(
    R.layout.activity_start,
    StartViewModel::class.java
) {
    override val viewModel by lazy { vm as StartViewModel }
    override val toolbarId = 0

    override fun initActivity() {

        viewModel.setObserves()

    }



    fun StartViewModel.setObserves(){

        action.observe(this@StartActivity, Observer { it ->
            viewModelScope.launch {
                delay(1500)
                when(it){
                    StartViewModel.StartAction.MOVE_LOGIN ->{
                        startActivity(
                            intentFor<LoginActivity>()
                        )
                        finish()

                    }

                    StartViewModel.StartAction.MOVE_MAIN ->{
                        startActivity(
                            intentFor<MainActivity>()
                        )
                        finish()

                    }

                    StartViewModel.StartAction.MOVE_ACCOUNT ->{
                        startActivity(
                            intentFor<AccountActivity>()
                        )
                        finish()

                    }
                }
            }
        })


    }
}