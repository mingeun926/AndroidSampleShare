package com.ymg.sample.data.network

import com.ymg.sample.data.network.mapper.ImageMapper
import com.ymg.sample.data.network.mapper.VideoMapper
import com.ymg.sample.data.network.source.SearchRemoteSource
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.domain.repository.SearchRepository



class SearchRepositoryImpl(
    private val searchRemoteSource: SearchRemoteSource,
    private val imageMapper: ImageMapper,
    private val videoMapper: VideoMapper,
) : SearchRepository {

    override suspend fun fetchImage(searchWord: String): List<Media> {
        return searchRemoteSource.fetchImage(searchWord).documents.map {
            imageMapper.map(it)
        }
    }

    override suspend fun fetchVideo(searchWord: String): List<Media> {
        return searchRemoteSource.fetchVideo(searchWord).documents.map {
            videoMapper.map(it)
        }
    }
}