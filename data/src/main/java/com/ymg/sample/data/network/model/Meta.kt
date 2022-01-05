package com.ymg.sample.data.network.model

import com.google.gson.annotations.SerializedName



data class Meta(
    @SerializedName("total_count")
    var totalCount: Int,

    @SerializedName("pageable_count")
    var pageableCount: Int,

    @SerializedName("is_end")
    var isEnd: Boolean
)