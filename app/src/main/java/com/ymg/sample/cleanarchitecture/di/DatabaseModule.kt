package com.ymg.sample.cleanarchitecture.di

import com.ymg.sample.data.local.db.StorageDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module



val dataBaseModule = module {

    single {
        StorageDatabase.getInstance(androidApplication())
    }

    single {
        get<StorageDatabase>().storageDao()
    }
}