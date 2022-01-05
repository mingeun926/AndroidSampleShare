package com.ymg.sample.data.network.mapper

import com.ymg.sample.data.network.model.Image
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.utils.Mapper



class ImageMapper : Mapper<Image, Media>() {

    override fun map(data: Image): Media = Media(
        thumbnail = data.thumbnailUrl,
        dateTime = data.datetime,
        type = Media.TYPE_IMAGE
    )

    override fun reverseMap(data: Media): Image = throw NotImplementedError()
}