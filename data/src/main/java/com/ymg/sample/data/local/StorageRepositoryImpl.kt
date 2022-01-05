package com.ymg.sample.data.local

import com.ymg.sample.data.local.mapper.StorageMapper
import com.ymg.sample.data.local.source.StorageLocalSource
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



class StorageRepositoryImpl(
    private val storageLocalSource: StorageLocalSource,
    private val storageMapper: StorageMapper
) : StorageRepository {

    override fun fetchAllItem(): Flow<List<Media>> {
        return storageLocalSource.fetchAllItem().map {
            storageMapper.map(it)
        }
    }

    override suspend fun fetchAddItem(data: Media) {
        storageLocalSource.fetchAddItem(storageMapper.reverseMap(data))
    }

    override suspend fun fetchRemoveItem(data: Media) {
        storageLocalSource.fetchRemoveItem(storageMapper.reverseMap(data))
    }
}