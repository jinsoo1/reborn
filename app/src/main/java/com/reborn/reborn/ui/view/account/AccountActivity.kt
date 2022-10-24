package com.reborn.reborn.ui.view.account

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityAccountBinding

import com.reborn.reborn.ui.view.account.experience.ExperienceFragment
import com.reborn.reborn.ui.view.account.height.HeightFragment
import com.reborn.reborn.ui.view.account.terms.TermsFragment
import com.reborn.reborn.ui.view.account.weight.WeightFragment
import com.reborn.reborn.ui.view.assessment.AssessmentActivity
import com.reborn.reborn.util.EventObserver
import com.reborn.reborn.util.FragmentUtils
import org.jetbrains.anko.intentFor

class AccountActivity : BaseVmActivity<ActivityAccountBinding>(
R.layout.activity_account,
AccountViewModel::class.java
) {
    override val viewModel: AccountViewModel by lazy { vm as AccountViewModel }

    override val toolbarId: Int = 0

    override fun initActivity() {

        viewModel.setObserves()
    }

    fun AccountViewModel.setObserves(){

        action.observe(this@AccountActivity, EventObserver{

            when(it){
                AccountViewModel.AccountAction.SUCCESS ->{
                    startActivity(
                        intentFor<AssessmentActivity>()
                    )
                   finish()
                }
            }

        })

        terms.observe(this@AccountActivity, Observer {
            if (it == 1) uploadMyAccount()
        })
    }

}


