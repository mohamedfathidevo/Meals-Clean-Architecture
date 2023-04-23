package com.mohamedfathidev.domain.util

import com.mohamedfathidev.domain.entity.Meal

sealed interface UiState {
    object Loading : UiState

    data class Success(
        val data: List<Meal>
    ) : UiState

    data class Error(
        val throwable: Throwable? = null
    ) : UiState
}