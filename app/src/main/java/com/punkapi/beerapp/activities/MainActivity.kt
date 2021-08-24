package com.punkapi.beerapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.punkapi.beerapp.R
import com.punkapi.beerapp.fragments.BeerListFragment
import com.punkapi.beerapp.viewModels.BeerListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BeerListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var searchfield:EditText = findViewById(R.id.search)
        searchfield.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        getBeerList()
    }


     private fun getBeerList(){
         viewModel = ViewModelProvider(this).get(BeerListViewModel::class.java)
         viewModel.getBeerList().observe(this, { list ->
             supportFragmentManager.beginTransaction().add(R.id.container, BeerListFragment.newInstance(list))
                     .commit()
         })
     }
}