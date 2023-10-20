package com.lycc.arch.mvi.ui

class MainState {
}

sealed class MainUiState {
    data object INIT : MainUiState()
    data class SUCCESS(val result: String) : MainUiState()
}