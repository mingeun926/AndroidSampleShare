package com.ymg.sample.cleanarchitecture.di

import com.ymg.sample.data.local.mapper.StorageMapper
import com.ymg.sample.data.network.mapper.ImageMapper
import com.ymg.sample.data.network.mapper.VideoMapper
import org.koin.dsl.module



val mapperModule = module {

    single {
        ImageMapper()
    }

    single {
        VideoMapper()
    }

    single {
        StorageMapper()
    }
}