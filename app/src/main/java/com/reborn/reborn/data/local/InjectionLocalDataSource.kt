package com.reborn.reborn.data.local

import com.reborn.reborn.data.local.pref.BDPreferences
import com.reborn.reborn.data.local.pref.PermanentPreferences
import com.reborn.reborn.data.local.pref.UserInfoPreferences
import org.koin.dsl.module

val localDataSourceModule = module {
    single<BDPreferences.UserInfo> { UserInfoPreferences(get()) }
    single<BDPreferences.Permanent> { PermanentPreferences(get()) }

    single<UserLoginLocalDataSource> { UserLoginLocalDataSource() }
}
