package com.ymg.sample.data.local.mapper

import com.ymg.sample.data.local.entity.StorageEntity
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.utils.Mapper



class StorageMapper : Mapper<StorageEntity, Media>() {

    override fun map(data: StorageEntity): Media = Media(
        id = data.id,
        thumbnail = data.thumbnail,
        dateTime = data.dateTime,
        type = data.type,
    )

    override fun reverseMap(data: Media): StorageEntity = StorageEntity(
        id = data.id,
        thumbnail = data.thumbnail,
        dateTime = data.dateTime,
        type = data.type,
    )
}