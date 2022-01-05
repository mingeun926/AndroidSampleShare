package com.ymg.sample.domain.usecase

import com.ymg.sample.domain.entity.Media
import com.ymg.sample.domain.repository.StorageRepository
import com.ymg.sample.domain.utils.CoroutineUseCase



class AddItemUseCase(
    private val storageRepository: StorageRepository
) : CoroutineUseCase<Media, Unit>() {

    override suspend fun execute() = throw NotImplementedError()

    override suspend fun execute(parameter: Media) {
        return storageRepository.fetchAddItem(parameter)
    }
}