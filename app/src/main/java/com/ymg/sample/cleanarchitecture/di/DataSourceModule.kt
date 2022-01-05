package com.ymg.sample.cleanarchitecture.di

import com.ymg.sample.data.local.source.StorageLocalSource
import com.ymg.sample.data.local.source.StorageLocalSourceImpl
import com.ymg.sample.data.network.source.SearchRemoteSource
import com.ymg.sample.data.network.source.SearchRemoteSourceImpl
import org.koin.dsl.module



val dataSourceModule = module {

    single<SearchRemoteSource> {
        SearchRemoteSourceImpl(get())
    }

    single<StorageLocalSource> {
        StorageLocalSourceImpl(get())
    }
}