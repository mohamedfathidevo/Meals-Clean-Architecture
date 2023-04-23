package com.mohamedfathidev.mealscleanarchitecture

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedfathidev.domain.entity.Meal
import com.mohamedfathidev.domain.usecase.GetMeals
import com.mohamedfathidev.domain.util.Constant
import com.mohamedfathidev.domain.util.Constant.TAG
import com.mohamedfathidev.domain.util.Result
import com.mohamedfathidev.domain.util.UiState
import com.mohamedfathidev.domain.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel
@Inject constructor(
    private val getMealsUseCase: GetMeals
) : ViewModel() {
    private val _mealsData = MutableStateFlow<UiState>(UiState.Loading)
    val mealsData: StateFlow<UiState> = _mealsData.asStateFlow()

    fun getMealsData() {
        viewModelScope.launch {
            getMealsUseCase().asResult().collect { result ->
                _mealsData.update {
                    when (result) {
                        is Result.Loading -> UiState.Loading
                        is Result.Success -> UiState.Success(result.data)
                        is Result.Error -> UiState.Error(result.exception)
                    }
                }
            }
        }
    }
}

