package com.reborn.reborn.ui.view.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityLoginBinding
import com.reborn.reborn.ui.view.assessment.rehab.CodeViewModel
import com.reborn.reborn.ui.view.main.MainActivity
import com.reborn.reborn.util.EventObserver

class LoginActivity : BaseVmActivity<ActivityLoginBinding>(
    R.layout.activity_login,
    LoginViewModel::class.java
) {
    override val viewModel: LoginViewModel by lazy { vm as LoginViewModel }

    override val toolbarId: Int = 0

    override fun initActivity() {

        Log.d(TAG, "keyhash : ${Utility.getKeyHash(this)}")

        viewModel.setObserves()

    }

    fun LoginViewModel.setObserves(){

        action.observe(lifecycleOwner, EventObserver{
            when(it){
                LoginViewModel.LoginActions.KAKAO -> {
                    //카카오 로그인
                    loginKakao()

                }
            }
        })
    }

    fun loginKakao(){

        KakaoSdk.init(this, "b5cce02d691dc3b8070098c2dbece43e")

        // 카카오톡 설치 확인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            // 카카오톡 로그인
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                // 로그인 실패 부분
                if (error != null) {
                    Log.d("카카오로그인", "로그인 실패, 에러 : "+error.toString())
                    // 사용자가 취소
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled ) {
                        return@loginWithKakaoTalk
                        Log.d("카카오로그인", "사용자가 취소 : "+error.reason.toString())

                    }
                    // 다른 오류
                    else {
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback) // 카카오 이메일 로그인
                        Log.d("카카오로그인", "그 외 오류# : "+error)
                    }
                }
                // 로그인 성공 부분
                else if (token != null) {
                    Log.d("카카오로그인", "로그인 성공 : "+token.toString())
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)

                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback) // 카카오 이메일 로그인
            Log.d("카카오로그인", "카카오톡 설치 안됨#")
        }
    }

    // 이메일 로그인 콜백
    private val mCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e(TAG, "로그인 실패 $error")
        } else if (token != null) {
            Log.e(TAG, "로그인 성공 ${token.accessToken}")
        }
    }
}