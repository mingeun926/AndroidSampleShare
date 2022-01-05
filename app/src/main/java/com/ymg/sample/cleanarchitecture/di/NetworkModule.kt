package com.ymg.sample.cleanarchitecture.di

import com.google.gson.GsonBuilder
import com.ymg.sample.cleanarchitecture.BuildConfig
import com.ymg.sample.cleanarchitecture.util.NetworkLogger
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



private const val CONNECT_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L

val networkModule = module {

    single {
        Cache(androidApplication().cacheDir, 10L * 1024 * 1024)
    }

    single {
        GsonBuilder().create()
    }

    single(named(BuildConfig.API_SCOPE)) {
        val networkClient = OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor { chain ->
                val request: Request = chain.request().newBuilder()
                    .addHeader("Authorization", "KakaoAK ${BuildConfig.API_KEY}").build()
                chain.proceed(request)
            }
            addInterceptor(HttpLoggingInterceptor(NetworkLogger()).apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
        }.build()

        Retrofit.Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(networkClient)
            .build()
    }
}