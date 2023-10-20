package com.lycc.arch.mvi.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState : IUiState> : ViewModel() {
    private val _uiStateFlow = MutableStateFlow(initUiState())
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow

    protected abstract fun initUiState(): UiState

    protected fun sendUiState(copy: UiState.() -> UiState) {
        _uiStateFlow.update { copy(_uiStateFlow.value) }
    }
}
