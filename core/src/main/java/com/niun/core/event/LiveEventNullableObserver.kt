package com.niun.core.event

import androidx.lifecycle.Observer

class LiveEventNullableObserver<T>(private val onEventUnhandled: (T?) -> Unit) :
    Observer<LiveEvent<T>> {
    override fun onChanged(event: LiveEvent<T>?) {
        event?.let {
            if (!it.hasBeenTriggered) {
                onEventUnhandled(it.getContentIfNotTriggered())
            }
        }
    }
}