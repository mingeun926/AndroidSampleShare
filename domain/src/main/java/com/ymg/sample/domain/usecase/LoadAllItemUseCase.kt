package com.ymg.sample.domain.usecase

import com.ymg.sample.domain.entity.Media
import com.ymg.sample.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow



class LoadAllItemUseCase(
    private val storageRepository: StorageRepository
)  {
    operator fun invoke(): Flow<List<Media>> {
        return storageRepository.fetchAllItem()
    }
}