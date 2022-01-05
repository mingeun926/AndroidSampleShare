package com.ymg.sample.domain.entity

import java.util.*



data class Media (
    val id: Int = 0,
    val thumbnail: String,
    val dateTime: Date,
    val type: String = TYPE_UNKNOWN
) {
    companion object {
        const val TYPE_UNKNOWN = "UNKNOWN"
        const val TYPE_IMAGE = "IMAGE"
        const val TYPE_VIDEO = "VIDEO"
    }
}