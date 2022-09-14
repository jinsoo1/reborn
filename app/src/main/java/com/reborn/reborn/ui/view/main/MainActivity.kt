package com.reborn.reborn.ui.view.main

import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityMainBinding

class MainActivity : BaseVmActivity<ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {
    override val viewModel: MainViewModel by lazy { vm as MainViewModel }

    override val toolbarId: Int = 0


    override fun initActivity() {
    }
}