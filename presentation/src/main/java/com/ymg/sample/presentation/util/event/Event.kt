package com.ymg.sample.presentation.util.event

import androidx.lifecycle.Observer



open class Event<out T>(val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

class EventObserver<T>(private val onEventUnhandledContent: (T?) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        if (event == null) {
            return
        }

        if (event.content == null && !event.hasBeenHandled) {
            event.getContentIfNotHandled()
            onEventUnhandledContent(null)
            return
        }

        event.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}