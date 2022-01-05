package com.ymg.sample.data.network.model

import com.google.gson.annotations.SerializedName
import java.util.*



data class Video (
    @SerializedName("title")
    var title: String,

    @SerializedName("url")
    var url: String,

    @SerializedName("datetime")
    var datetime: Date,

    @SerializedName("play_time")
    var playTime: Int,

    @SerializedName("thumbnail")
    var thumbnail: String,

    @SerializedName("author")
    var author: String
)