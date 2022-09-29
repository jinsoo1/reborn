package com.reborn.reborn.ui.view.account

import android.util.Log
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityAccountBinding

import com.reborn.reborn.ui.view.account.experience.ExperienceFragment
import com.reborn.reborn.ui.view.account.height.HeightFragment
import com.reborn.reborn.ui.view.account.terms.TermsFragment
import com.reborn.reborn.ui.view.account.weight.WeightFragment
import com.reborn.reborn.util.EventObserver
import com.reborn.reborn.util.FragmentUtils

class AccountActivity : BaseVmActivity<ActivityAccountBinding>(
R.layout.activity_account,
AccountViewModel::class.java
) {
    override val viewModel: AccountViewModel by lazy { vm as AccountViewModel }

    override val toolbarId: Int = 0

    private val heightFragment: HeightFragment by lazy { HeightFragment() }
    private val weightFragment: WeightFragment by lazy { WeightFragment() }
    private val experienceFragment: ExperienceFragment by lazy { ExperienceFragment() }
    private val termsFragment: TermsFragment by lazy { TermsFragment() }

    private val fragments: FragmentUtils by lazy {
        FragmentUtils(
            R.id.fragment_container,
            supportFragmentManager,
            arrayOf(
                heightFragment,
                weightFragment,
                experienceFragment,
                termsFragment
            )
        )
    }

    override fun initActivity() {

        switchPage(0)

        viewModel.setObserves()
    }

    fun AccountViewModel.setObserves(){

        action.observe(this@AccountActivity, EventObserver{
            when(it) {
                AccountViewModel.AccountAction.REPLACE_PAGE_HEIGHT -> {
                    switchPage(1)
                }

                AccountViewModel.AccountAction.REPLACE_PAGE_WEIGHT -> {
                    switchPage(2)
                }

                AccountViewModel.AccountAction.REPLACE_PAGE_EXPERIENCE -> {
                    switchPage(3)
                    Log.d("다음", "약관동의 페이지로 넘어감 ! ")
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


