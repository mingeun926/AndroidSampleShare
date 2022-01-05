package com.ymg.sample.data.network.api

import com.ymg.sample.data.network.model.Image
import com.ymg.sample.data.network.model.Search
import com.ymg.sample.data.network.model.Video
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface SearchApi {

    @GET("/v2/search/image")
    suspend fun fetchImage(
        @Query("query")
        query: String
    ): Response<Search<Image>>

    @GET("/v2/search/vclip")
    suspend fun fetchVideo(
        @Query("query")
        query: String
    ): Response<Search<Video>>
}