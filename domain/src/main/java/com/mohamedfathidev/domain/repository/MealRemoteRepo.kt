package com.mohamedfathidev.domain.repository

import com.mohamedfathidev.domain.entity.Meal

interface MealRemoteRepo {
    suspend fun getMealsFromRemote(): List<Meal>
}