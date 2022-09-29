package com.reborn.reborn.ui.view.login

import android.util.Log
import com.kakao.sdk.common.util.Utility
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityLoginBinding

class LoginActivity : BaseVmActivity<ActivityLoginBinding>(
    R.layout.activity_login,
    LoginViewModel::class.java
) {
    override val viewModel: LoginViewModel by lazy { vm as LoginViewModel }

    override val toolbarId: Int = 0

    override fun initActivity() {




    }

}