package com.attrecto.academy.android.data.api

import com.attrecto.academy.android.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Network {
    private fun provideClient() = OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()

    private fun provideMoshi() = MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build())

    private fun provideRetrofit() = Retrofit
        .Builder()
        .client(provideClient())
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(provideMoshi())
        .build()

    private fun provideMoviesApi(): MoviesApi = provideRetrofit().create()

    val moviesApi = provideMoviesApi()
}