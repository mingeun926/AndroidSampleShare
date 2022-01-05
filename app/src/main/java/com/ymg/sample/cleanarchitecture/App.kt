package com.ymg.sample.cleanarchitecture

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.ymg.sample.cleanarchitecture.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin



class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Logger 설정
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(0)
            .methodOffset(7)
            .tag("DEBUG")
            .build()

        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })

        // Koin 설정
        startKoin {
            androidLogger()
            androidContext(this@App)

            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    networkModule,
                    apiModule,
                    dataBaseModule,
                    repositoryModule,
                    mapperModule,
                    dataSourceModule
                )
            )
        }
    }
}