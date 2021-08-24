package com.punkapi.beerapp.service

import androidx.lifecycle.MutableLiveData
import com.punkapi.beerapp.models.BeerModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("beers")
    fun getBeersList(): Call<ArrayList<BeerModel>>

}