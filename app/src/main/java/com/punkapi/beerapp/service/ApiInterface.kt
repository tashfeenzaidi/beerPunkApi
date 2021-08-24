package com.punkapi.beerapp.service

import com.punkapi.beerapp.models.BeerModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface ApiInterface {

    @GET("beers")
    fun getBeersList(): Call<ArrayList<BeerModel>>

    @GET("beers")
    fun getBeers(@QueryMap filters: Map<String?, String?>?): Call<ArrayList<BeerModel>>

}