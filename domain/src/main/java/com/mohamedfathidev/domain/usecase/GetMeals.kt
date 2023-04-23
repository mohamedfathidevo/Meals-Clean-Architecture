package com.mohamedfathidev.domain.usecase

import com.mohamedfathidev.domain.entity.Meal
import com.mohamedfathidev.domain.repository.MealRemoteRepo
import com.mohamedfathidev.domain.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMeals(
    private val mealRemoteRepo: MealRemoteRepo
){
    suspend operator fun invoke(): Flow<List<Meal>> = flow {
        val result = mealRemoteRepo.getMealsFromRemote()
        emit(result)
    }
}