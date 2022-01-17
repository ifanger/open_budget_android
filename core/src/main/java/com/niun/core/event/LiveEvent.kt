package com.niun.core.event

class LiveEvent<T>(private val event: T) {

    var hasBeenTriggered = false
        private set

    fun getContentIfNotTriggered(): T? {
        return if (hasBeenTriggered) {
            null
        } else {
            hasBeenTriggered = true
            event
        }
    }

    fun peek(): T = event
}