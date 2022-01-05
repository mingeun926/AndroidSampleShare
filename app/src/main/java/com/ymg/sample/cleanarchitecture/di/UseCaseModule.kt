package com.ymg.sample.cleanarchitecture.di

import com.ymg.sample.domain.usecase.AddItemUseCase
import com.ymg.sample.domain.usecase.LoadAllItemUseCase
import com.ymg.sample.domain.usecase.RemoveItemUseCase
import com.ymg.sample.domain.usecase.SearchUseCase
import org.koin.dsl.module



val useCaseModule = module {

    factory {
         SearchUseCase(get())
    }

    factory {
        LoadAllItemUseCase(get())
    }

    factory {
        AddItemUseCase(get())
    }

    factory {
        RemoveItemUseCase(get())
    }
}