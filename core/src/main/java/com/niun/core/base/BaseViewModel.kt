package com.niun.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niun.core.state.ViewAction
import com.niun.core.state.ViewEvent
import com.niun.core.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : ViewState, E : ViewEvent, A : ViewAction> : ViewModel() {

    abstract fun getInitialState(): S

    private val _state = MutableStateFlow<S?>(null)
    val state get() = _state.asStateFlow()

    private val _event = MutableStateFlow<E?>(null)
    val event get() = _event.asStateFlow()

    abstract fun sendAction(action: A)

    fun getState(): S = _state.value ?: getInitialState()

    protected fun updateState(state: S) {
        viewModelScope.launch {
            _state.value = state
        }
    }

    protected fun sendEvent(event: E) {
        viewModelScope.launch {
            _event.value = event
        }
    }
}