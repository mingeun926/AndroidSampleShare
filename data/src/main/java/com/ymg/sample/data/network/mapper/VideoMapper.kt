package com.ymg.sample.data.network.mapper

import com.ymg.sample.data.network.model.Video
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.utils.Mapper



class VideoMapper : Mapper<Video, Media>() {

    override fun map(data: Video): Media = Media(
        thumbnail = data.thumbnail,
        dateTime = data.datetime,
        type = Media.TYPE_VIDEO
    )

    override fun reverseMap(data: Media): Video = throw NotImplementedError()
}