package com.ymg.sample.extention

import retrofit2.Response



fun<T> Response<T>.verify() : T {
    if (this.isSuccessful && this.code() in 200..299) {
        return this.body() ?: throw Exception("${this.code()}")
    } else {
        throw Exception("${this.code()}")
    }
}

fun<T> Response<List<T>>.verify() : List<T> {
    if (this.isSuccessful && this.code() in 200..299) {
        return this.body() ?: listOf()
    } else {
        throw Exception("${this.code()}")
    }
}