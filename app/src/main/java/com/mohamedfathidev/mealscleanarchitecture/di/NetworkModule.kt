package com.mohamedfathidev.mealscleanarchitecture.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mohamedfathidev.data.remote.ApiService
import com.mohamedfathidev.data.remote.MealNetworkEntity
import com.mohamedfathidev.data.remote.NetworkMapper
import com.mohamedfathidev.domain.entity.Meal
import com.mohamedfathidev.domain.util.Constant.BASE_URL
import com.mohamedfathidev.domain.util.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<MealNetworkEntity, Meal> {
        return NetworkMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Provides
    @Singleton
    fun provideOKHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}

