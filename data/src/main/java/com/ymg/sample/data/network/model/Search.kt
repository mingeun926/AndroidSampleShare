package com.ymg.sample.data.network.model

import com.google.gson.annotations.SerializedName



data class Search<T>(
    @SerializedName("meta")
    var meta: Meta,

    @SerializedName("documents")
    var documents: List<T>
)
