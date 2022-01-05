package com.ymg.sample.data.local.source

import com.ymg.sample.data.local.dao.StorageDao
import com.ymg.sample.data.local.entity.StorageEntity
import kotlinx.coroutines.flow.Flow



interface StorageLocalSource {

    fun fetchAllItem(): Flow<List<StorageEntity>>

    suspend fun fetchAddItem(data: StorageEntity)

    suspend fun fetchRemoveItem(data: StorageEntity)
}

class StorageLocalSourceImpl(
    private val storageDao: StorageDao
) : StorageLocalSource {

    override fun fetchAllItem(): Flow<List<StorageEntity>> = storageDao.findAll()

    override suspend fun fetchAddItem(data: StorageEntity) = storageDao.insert(data)

    override suspend fun fetchRemoveItem(data: StorageEntity) = storageDao.delete(data)
}