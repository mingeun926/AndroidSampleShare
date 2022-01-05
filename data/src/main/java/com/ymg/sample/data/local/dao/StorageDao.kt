package com.ymg.sample.data.local.dao

import androidx.room.*
import com.ymg.sample.data.local.entity.StorageEntity
import kotlinx.coroutines.flow.Flow



@Dao
interface StorageDao {

    @Query("SELECT * FROM storage ORDER BY dateTime DESC")
    fun findAll(): Flow<List<StorageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: StorageEntity)

    @Delete
    suspend fun delete(data: StorageEntity)
}