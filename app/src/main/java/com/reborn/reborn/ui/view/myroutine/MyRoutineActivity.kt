package com.reborn.reborn.ui.view.myroutine

import androidx.navigation.fragment.NavHostFragment
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityMyroutineBinding
import com.reborn.reborn.util.KeepStateNavigator

class MyRoutineActivity : BaseVmActivity<ActivityMyroutineBinding>(
    R.layout.activity_myroutine,
    MyRoutineViewModel::class.java
) {
    override val viewModel by lazy { vm as MyRoutineViewModel }
    override val toolbarId = 0

    override fun initActivity() {

        val navHostFragment = supportFragmentManager.findFragmentById(binding.navHost.id) as NavHostFragment
        val navController = navHostFragment.navController

        val navigator = KeepStateNavigator(this, navHostFragment.childFragmentManager, binding.navHost.id)
        navController.navigatorProvider.addNavigator(navigator)

        navController.setGraph(R.navigation.nav_graph_myroutine)

    }
}