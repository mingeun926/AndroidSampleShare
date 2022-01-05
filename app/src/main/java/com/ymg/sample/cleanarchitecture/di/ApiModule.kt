package com.ymg.sample.cleanarchitecture.di

import com.ymg.sample.cleanarchitecture.BuildConfig
import com.ymg.sample.data.network.api.SearchApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit



val apiModule = module {

    single {
        get<Retrofit>(named(BuildConfig.API_SCOPE)).create(SearchApi::class.java)
    }
}