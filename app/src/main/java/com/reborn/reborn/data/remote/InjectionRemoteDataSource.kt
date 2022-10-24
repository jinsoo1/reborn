package com.reborn.reborn.data.remote

import com.reborn.reborn.data.remote.api.PainApi
import com.reborn.reborn.data.remote.source.*
import org.koin.dsl.module

val remoteDataSourceModule = module {

    single { AuthDataSource(get()) }
    single { UserDataSource(get()) }
    single { PainDataSource(get()) }
    single { SearchDataSource(get()) }
    single { RoutineDataSource(get()) }
    single { ExerciseDataSource(get()) }
}
