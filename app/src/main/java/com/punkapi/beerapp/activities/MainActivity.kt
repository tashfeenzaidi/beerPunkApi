package com.punkapi.beerapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.punkapi.beerapp.R
import com.punkapi.beerapp.fragments.BeerListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, BeerListFragment.newInstance())
                .commit()
    }
}