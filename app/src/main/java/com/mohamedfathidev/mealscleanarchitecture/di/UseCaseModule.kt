package com.mohamedfathidev.mealscleanarchitecture.di

import com.mohamedfathidev.domain.repository.MealRemoteRepo
import com.mohamedfathidev.domain.usecase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(mealsRemoteRepo: MealRemoteRepo): GetMeals {
        return GetMeals(mealsRemoteRepo)
    }
}