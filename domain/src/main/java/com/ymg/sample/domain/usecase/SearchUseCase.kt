package com.ymg.sample.domain.usecase

import com.ymg.sample.domain.entity.Media
import com.ymg.sample.domain.repository.SearchRepository
import com.ymg.sample.domain.utils.CoroutineUseCase



class SearchUseCase(
    private val searchRepository: SearchRepository,
) : CoroutineUseCase<String, List<Media>>() {

    override suspend fun execute(): List<Media> = throw NotImplementedError()

    override suspend fun execute(parameter: String): List<Media> {
        return (searchRepository.fetchImage(parameter) + searchRepository.fetchVideo(parameter)).sortedByDescending {
            it.dateTime
        }
    }
}