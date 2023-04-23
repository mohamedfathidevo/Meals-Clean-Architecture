package com.mohamedfathidev.data.repository

import com.mohamedfathidev.data.remote.ApiService
import com.mohamedfathidev.data.remote.NetworkMapper
import com.mohamedfathidev.domain.entity.Meal
import com.mohamedfathidev.domain.repository.MealRemoteRepo

class MealRemoteRepoImpl(
    private val apiService: ApiService,
    private val networkMapper: NetworkMapper
): MealRemoteRepo {
    override suspend fun getMealsFromRemote(): List<Meal> {
        return networkMapper.mapFromEntityList(apiService.getMeals())
    }
}