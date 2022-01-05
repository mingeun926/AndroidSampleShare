package com.ymg.sample.utils



abstract class Mapper<T1, T2> {

    abstract fun map(data: T1): T2

    abstract fun reverseMap(data: T2): T1

    fun map(data: List<T1>): List<T2> {
        return data
            .asSequence()
            .map { map(it) }
            .toList()
    }

    fun reverseMap(data: List<T2>): List<T1> {
        return data
            .asSequence()
            .map { reverseMap(it) }
            .toList()
    }
}