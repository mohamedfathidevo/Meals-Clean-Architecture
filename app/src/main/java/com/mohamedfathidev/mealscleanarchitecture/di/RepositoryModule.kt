package com.mohamedfathidev.mealscleanarchitecture.di

import com.mohamedfathidev.data.remote.ApiService
import com.mohamedfathidev.data.remote.NetworkMapper
import com.mohamedfathidev.data.repository.MealRemoteRepoImpl
import com.mohamedfathidev.domain.repository.MealRemoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRemoteRepo(
        apiService: ApiService,
        networkMapper: NetworkMapper
    ): MealRemoteRepo{
        return MealRemoteRepoImpl(
            apiService,
            networkMapper
        )
    }

}