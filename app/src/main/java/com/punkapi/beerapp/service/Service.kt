package com.punkapi.beerapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Service {

    companion object{
        private const val baseUrl:String = "https://api.punkapi.com/v2/"

        fun  getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}