package com.ymg.sample.domain.usecase

import com.ymg.sample.domain.repository.StorageRepository
import com.ymg.sample.domain.utils.CoroutineUseCase
import com.ymg.sample.domain.entity.Media



class RemoveItemUseCase(
    private val storageRepository: StorageRepository
) : CoroutineUseCase<Media, Unit>() {

    override suspend fun execute() = throw NotImplementedError()

    override suspend fun execute(parameter: Media) {
        return storageRepository.fetchRemoveItem(parameter)
    }
}