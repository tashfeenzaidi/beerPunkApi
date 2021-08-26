package com.punkapi.beerapp.appModule

import com.punkapi.beerapp.service.ApiInterface
import com.punkapi.beerapp.service.Service
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val serviceModule = module {
    single { provideRetrofit( Service.BASE_URL) }
    single { provideApiService(get()) }
}

private fun provideRetrofit(
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

private fun provideApiService(retrofit: Retrofit): ApiInterface =
    retrofit.create(ApiInterface::class.java)

