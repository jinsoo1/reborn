package com.reborn.reborn.data.common

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.reborn.reborn.BuildConfig
import com.reborn.reborn.data.common.interceptor.ErrorInterceptor
import com.reborn.reborn.data.common.interceptor.HeaderInterceptor
import com.reborn.reborn.data.remote.api.*
import com.reborn.reborn.data.remote.source.PainDataSource
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule = module {

    single {
        HttpLoggingInterceptor(LoggerInterceptor()).apply {
            level = if (BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.BODY
            }else{
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single { HeaderInterceptor() }

    single { ErrorInterceptor() }

    single {
        GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<HeaderInterceptor>())
            .addInterceptor(get<ErrorInterceptor>())
            .build()
    }

    single { RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()) }

    single { GsonConverterFactory.create() }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get<OkHttpClient>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single<AuthApi> { get<Retrofit>().create(AuthApi::class.java) }
    single<UserApi> { get<Retrofit>().create(UserApi::class.java) }
    single<PainApi> { get<Retrofit>().create(PainApi::class.java) }
    single<SearchApi>{ get<Retrofit>().create(SearchApi::class.java)}
    single<RoutineApi> { get<Retrofit>().create(RoutineApi::class.java) }
    single<ExerciseApi> { get<Retrofit>().create(ExerciseApi::class.java) }


}


class LoggerInterceptor : HttpLoggingInterceptor.Logger{
    companion object {
        const val LOG_DIVIDER = "================================================================"
    }

    private val gson = GsonBuilder().setPrettyPrinting().create()

    override fun log(message: String) {
        val trimMessage = message.trim { it <= ' ' }
        if (trimMessage.startsWith("{") && trimMessage.endsWith("}")
            || trimMessage.startsWith("[") && trimMessage.endsWith("]")
        ) {
            try {
                val prettyPrintJson = gson.toJson(JsonParser().parse(message))
                Log.e("Network Response", LOG_DIVIDER + "\n" + prettyPrintJson + "\n" + LOG_DIVIDER)
            } catch (e: Exception) {
                Log.d("Network Response", message, null)
            }
        } else {
            Log.e("Network Response", message, null)
        }
    }

}