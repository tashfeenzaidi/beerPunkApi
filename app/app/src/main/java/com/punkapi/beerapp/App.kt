package com.punkapi.beerapp

import android.app.Application
import com.punkapi.beerapp.appModule.serviceModule
import com.punkapi.beerapp.appModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule,serviceModule))
        }
    }
}