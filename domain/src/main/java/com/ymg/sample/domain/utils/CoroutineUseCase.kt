package com.ymg.sample.domain.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext



abstract class CoroutineUseCase<P, R> {

    protected abstract suspend fun execute() : R
    protected abstract suspend fun execute(parameter: P) : R



    operator fun invoke(
        scope: CoroutineScope,
        dispatcher: CoroutineContext,
        onResult: (R) -> Unit = {}
    ) {
        scope.launch(dispatcher) {
            val result = execute()
            onResult(result)
        }
    }

    operator fun invoke(
        scope: CoroutineScope,
        dispatcher: CoroutineContext,
        parameter: P,
        onResult: (R) -> Unit = {}
    ) {
        scope.launch(dispatcher) {
            val result = execute(parameter)
            onResult(result)
        }
    }
}