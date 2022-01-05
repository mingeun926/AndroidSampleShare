package com.ymg.sample.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ymg.sample.data.local.convert.DateConverter
import java.util.*



@Entity(tableName = "storage")
@TypeConverters(DateConverter::class)
data class StorageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,

    @ColumnInfo(name = "dateTime")
    val dateTime: Date,

    @ColumnInfo(name = "type")
    val type: String
)