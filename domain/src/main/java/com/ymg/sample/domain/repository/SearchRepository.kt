package com.ymg.sample.domain.repository

import com.ymg.sample.domain.entity.Media



interface SearchRepository {

    suspend fun fetchImage(searchWord: String): List<Media>

    suspend fun fetchVideo(searchWord: String): List<Media>
}