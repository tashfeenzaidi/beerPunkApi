package com.punkapi.beerapp.appModule

import com.punkapi.beerapp.viewModels.BeerListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
         BeerListViewModel(get())
    }
}