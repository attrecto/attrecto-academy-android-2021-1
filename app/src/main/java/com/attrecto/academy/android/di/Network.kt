package com.attrecto.academy.android.di

import com.attrecto.academy.android.data.api.MovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun provideClient() = OkHttpClient
    .Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

fun provideConverterFactory() = MoshiConverterFactory.create(
    Moshi.Builder().add(
        KotlinJsonAdapterFactory()
    ).build())


/*
    6. Feladat
    Retrofit példa:
    https://square.github.io/retrofit/

    - Add meg a baseUrl-t
 */

fun provideRetrofit() = Retrofit
    .Builder()
    .client(provideClient())
    .baseUrl("TODO baseUrl")
    .addConverterFactory(provideConverterFactory())
    .build()

/*
    7. Feladat
    Retrofit példa:
    https://square.github.io/retrofit/

    - Készíts provideMovieService() függvényt ami elkészíti a retorfit-tel a MovieService implementációját.
 */
