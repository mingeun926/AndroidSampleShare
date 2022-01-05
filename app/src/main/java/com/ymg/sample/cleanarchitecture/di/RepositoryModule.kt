package com.ymg.sample.cleanarchitecture.di

import com.ymg.sample.data.local.StorageRepositoryImpl
import com.ymg.sample.data.network.SearchRepositoryImpl
import com.ymg.sample.domain.repository.SearchRepository
import com.ymg.sample.domain.repository.StorageRepository
import org.koin.dsl.module



val repositoryModule = module {

    single<SearchRepository> {
        SearchRepositoryImpl(get(), get(), get())
    }

    single<StorageRepository> {
        StorageRepositoryImpl(get(), get())
    }
}