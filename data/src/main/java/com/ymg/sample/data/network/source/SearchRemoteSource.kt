package com.ymg.sample.data.network.source

import com.ymg.sample.data.network.api.SearchApi
import com.ymg.sample.data.network.model.Image
import com.ymg.sample.data.network.model.Search
import com.ymg.sample.data.network.model.Video
import com.ymg.sample.extention.verify



interface SearchRemoteSource {

    suspend fun fetchImage(searchWord: String): Search<Image>

    suspend fun fetchVideo(searchWord: String): Search<Video>
}

class SearchRemoteSourceImpl(
    private val searchApi: SearchApi
): SearchRemoteSource {

    override suspend fun fetchImage(searchWord: String): Search<Image> =
        searchApi.fetchImage(searchWord).verify()

    override suspend fun fetchVideo(searchWord: String): Search<Video> =
        searchApi.fetchVideo(searchWord).verify()
}