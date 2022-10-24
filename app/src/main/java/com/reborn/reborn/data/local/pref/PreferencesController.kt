package com.reborn.reborn.data.local.pref

import org.koin.core.KoinComponent
import org.koin.core.inject

object PreferencesController : KoinComponent {
    val userInfoPref: BDPreferences.UserInfo by inject()
    val permanentPref: BDPreferences.Permanent by inject()
}