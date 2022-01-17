package com.niun.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.niun.core.state.ViewAction
import com.niun.core.state.ViewEvent
import com.niun.core.state.ViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment<
        VS : ViewState,
        VE : ViewEvent,
        VA : ViewAction,
        VM : BaseViewModel<VS, VE, VA>,
        VB : ViewBinding> : Fragment() {

    abstract val viewModel: VM

    private var _binding: VB? = null

    protected val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = onCreateBinding(inflater, container)
        return binding.root
    }

    abstract fun onCreateBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { onStateChanged(it) }
                viewModel.event.collect { onEventChanged(it) }
            }
        }
    }

    abstract fun onStateChanged(newState: VS?)

    abstract fun onEventChanged(event: VE?)

    protected fun sendAction(action: VA) {
        viewModel.sendAction(action)
    }

    fun View.sendClickAction(action: VA) {
        setOnClickListener { sendAction(action) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}