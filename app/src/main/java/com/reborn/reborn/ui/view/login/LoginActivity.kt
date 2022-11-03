package com.reborn.reborn.ui.view.login

import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.kakao.sdk.auth.network.RxAuthOperations
import com.kakao.sdk.common.model.ApiError
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.rx
import com.reborn.reborn.R
import com.reborn.reborn.base.App.Companion.toast
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.data.local.UserLoginLocalDataSource
import com.reborn.reborn.data.local.pref.PreferencesController
import com.reborn.reborn.data.remote.model.response.UserResponse
import com.reborn.reborn.data.remote.source.AuthDataSource
import com.reborn.reborn.databinding.ActivityLoginBinding
import com.reborn.reborn.ui.view.account.AccountActivity
import com.reborn.reborn.ui.view.assessment.AssessmentActivity
import com.reborn.reborn.ui.view.main.MainActivity
import com.reborn.reborn.ui.view.main.MainViewModel
import com.reborn.reborn.util.EventObserver
import com.reborn.reborn.util.ext.onUI
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.intentFor
import org.koin.android.ext.android.inject


class LoginActivity : BaseVmActivity<ActivityLoginBinding>(
    R.layout.activity_login,
    LoginViewModel::class.java
) {
    override val viewModel: LoginViewModel by lazy { vm as LoginViewModel }

    override val toolbarId: Int = 0


    private lateinit var resultLauncher : ActivityResultLauncher<Intent>

    //구글로그인 초기설정
    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
    private lateinit var googleSignInIntent : GoogleSignInClient

    private val authDataSource: AuthDataSource by inject()
    private val userLoginLocalDataSource: UserLoginLocalDataSource by inject()

    override fun initActivity() {
        googleSignInIntent = GoogleSignIn.getClient(this@LoginActivity, gso)
        signOut()

        resultGoogleLogin()

        viewModel.setObserves()
    }


    fun LoginViewModel.setObserves(){

        action.observe(lifecycleOwner, EventObserver{
            when(it){
                LoginViewModel.LoginActions.KAKAO -> {
                    //카카오 로그인
                    loginKakao()
                }

                LoginViewModel.LoginActions.GOOGLE ->{
                    //구글로그인
                    loginGoogle()
                }

                LoginViewModel.LoginActions.LOGIN ->{
                    //로그인성공

                    if(PreferencesController.userInfoPref.agree){
                        startActivity(
                            intentFor<MainActivity>()
                        )
                       finish()
                    }else{
                        startActivity(
                            intentFor<AccountActivity>()
                        )
                        finish()
                    }
                }
            }
        })
    }


    private fun loginKakao(){

        Single.just(UserApiClient.instance.isKakaoTalkLoginAvailable(this))
            .flatMap { available ->
                if (available) UserApiClient.rx.loginWithKakaoTalk(this)
                else UserApiClient.rx.loginWithKakaoAccount(this)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ token ->
                UserApiClient.rx.me()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ user ->
                        user.kakaoAccount?.email?.run {
                            Log.d("kakaoEmail", user.kakaoAccount!!.email!!)
                            authDataSource
                                .loginByKaKao(user.id.toString(), user.kakaoAccount?.email!!)
                                .onUI {
                                    onLoginSuccess(it)
                                }

                        } ?: scopesKakao()
                    }, { error ->
                        error.printStackTrace()
                    })
                    .addTo(viewModel.compositeDisposable)
            }, { error ->
                Log.d("kakaoE", error.toString())
                error.printStackTrace()
            })
            .addTo(viewModel.compositeDisposable)

    }

    // 카카오 미설치 기기에서 이메일 수집 추가하는 함수
    fun scopesKakao(){
        UserApiClient.rx.me()
            .flatMap { user ->

                var scopes = mutableListOf<String>()

                if (user.kakaoAccount?.emailNeedsAgreement == true) { scopes.add("account_email") }
                if (user.kakaoAccount?.birthdayNeedsAgreement == true) { scopes.add("birthday") }
                if (user.kakaoAccount?.birthyearNeedsAgreement == true) { scopes.add("birthyear") }
                if (user.kakaoAccount?.genderNeedsAgreement == true) { scopes.add("gender") }
                if (user.kakaoAccount?.phoneNumberNeedsAgreement == true) { scopes.add("phone_number") }
                if (user.kakaoAccount?.profileNeedsAgreement == true) { scopes.add("profile") }
                if (user.kakaoAccount?.ageRangeNeedsAgreement == true) { scopes.add("age_range") }
                if (user.kakaoAccount?.ciNeedsAgreement == true) { scopes.add("account_ci") }



                if (scopes.count() > 0) {
                    Log.d("scopes", "사용자에게 추가 동의를 받아야 합니다.")

                    // OpenID Connect 사용 시
                    // scope 목록에 "openid" 문자열을 추가하고 요청해야 함
                    // 해당 문자열을 포함하지 않은 경우, ID 토큰이 재발급되지 않음
                    // scopes.add("openid")

                    // scope 목록을 전달하여 InsufficientScope 에러 생성
                    Single.error(ApiError.fromScopes(scopes))
                }
                else {
                    Single.just(user)
                }
            }
            .retryWhen(
                // InsufficientScope 에러에 대해 추가 동의 후 재요청
                RxAuthOperations.instance.incrementalAuthorizationRequired(this)
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user ->
                user.kakaoAccount?.email?.run {
                    Log.d("kakaoEmail", user.kakaoAccount!!.email!!)
                    authDataSource
                        .loginByKaKao(user.id.toString(), user.kakaoAccount?.email!!)
                        .onUI {
                            onLoginSuccess(it)
                        }

                } ?: toast("카카오 로그인 실패")
            }, { error ->
                Log.e("scopes", "사용자 정보 요청 실패", error)
            })
            .addTo(viewModel.compositeDisposable)
    }


    private fun loginGoogle(){
        val signInIntent = googleSignInIntent.signInIntent

        resultLauncher.launch(signInIntent)

    }

    private fun resultGoogleLogin(){

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try{
                    val account = task.getResult(ApiException::class.java)

                    authDataSource
                        .loginByGoogle(account.id ?: "", account.email ?: "")
                        .subscribe({
                            Log.d("GoogleAccount", it.toString())
                            onLoginSuccess(it)
                        },{
                            Log.d("GoogleAccount", it.toString())
                            it.printStackTrace()
                        })
                        .addTo(viewModel.compositeDisposable)
                }catch (e: ApiException){
                    toast("구글로그인 실패")
                }
            }
        }
    }

    //구글로그인 확인후 로그아웃
    private fun signOut() {
        val googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this@LoginActivity)
        if(googleSignInAccount != null){
            googleSignInIntent.signOut()
                .addOnCompleteListener(this, OnCompleteListener<Void?> {
                    toast("구글 로그아웃")
                })
        }
    }

    //기기에 유저정보 저장
    private fun onLoginSuccess(response: UserResponse) {
        userLoginLocalDataSource.saveLoginInfo(response.user)
        userLoginLocalDataSource.saveAccessToken(response.accessToken)
        userLoginLocalDataSource.saveRefreshToken(response.refreshToken)

        viewModel.successLogin()
    }

}