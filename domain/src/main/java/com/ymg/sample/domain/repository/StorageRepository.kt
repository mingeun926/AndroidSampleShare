package com.ymg.sample.domain.repository

import com.ymg.sample.domain.entity.Media
import kotlinx.coroutines.flow.Flow



interface StorageRepository {

    fun fetchAllItem(): Flow<List<Media>>

    suspend fun fetchAddItem(data: Media)

    suspend fun fetchRemoveItem(data: Media)
}