package com.reborn.reborn.data.local

import com.reborn.reborn.data.common.model.User
import com.reborn.reborn.data.local.pref.PreferencesController.userInfoPref

class UserLoginLocalDataSource {


    fun saveLoginInfo(
        user: User
    ) {
        userInfoPref.apply {
            userType = user.userType
            userToken = user.userToken
            nickname = user.name
            email = user.email
            profileImg = user.profileImg ?: ""
            agree = user.agree == 1
        }
    }


    fun saveAccessToken(accessToken: String){
        userInfoPref.accessToken = accessToken
    }

    fun saveRefreshToken(refreshToken: String){
        userInfoPref.refreshToken = refreshToken
    }

    fun clearPref() {
        userInfoPref.clearPref()
    }


}