package com.punkapi.beerapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.punkapi.beerapp.models.BeerModel
import com.punkapi.beerapp.service.ApiInterface
import com.punkapi.beerapp.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class BeerListViewModel : ViewModel() {

    private var retrofit: Retrofit = Service.getInstance()
    private val service: ApiInterface = retrofit.create(ApiInterface::class.java)
    var beerList : MutableLiveData<ArrayList<BeerModel>> = MutableLiveData<ArrayList<BeerModel>>()

    fun getBeerList() : LiveData<ArrayList<BeerModel>>{
        val call = service.getBeersList()
        call.enqueue(object : Callback<ArrayList<BeerModel>>{
            override fun onResponse(
                call: Call<ArrayList<BeerModel>>,
                response: Response<ArrayList<BeerModel>>
            ) {
                if(response.code() == 200){
                    beerList.value = response.body()
                }
            }

            override fun onFailure(call: Call<ArrayList<BeerModel>>, t: Throwable) {
               println("error occour")
            }


        })
     return beerList
    }

}