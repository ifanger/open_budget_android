package com.niun.core.event

import androidx.lifecycle.Observer

class LiveEventObserver<T>(private val onEventUnhandled: (T) -> Unit) : Observer<LiveEvent<T>> {
    override fun onChanged(event: LiveEvent<T>?) {
        event?.getContentIfNotTriggered()?.let {
            onEventUnhandled(it)
        }
    }
}