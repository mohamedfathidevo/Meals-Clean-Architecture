package com.mohamedfathidev.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getMeals(): List<MealNetworkEntity>
}