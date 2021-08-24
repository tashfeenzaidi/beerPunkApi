package com.punkapi.beerapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
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

        val searchField:EditText = findViewById(R.id.search)
        searchField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                Toast.makeText(this@MainActivity, p0, Toast.LENGTH_SHORT).show()
                viewModel.getSearchResults(p0.toString())
            }

        })
        getBeerList()
    }

     private fun getBeerList(){
         viewModel = ViewModelProvider(this).get(BeerListViewModel::class.java)
         viewModel.getBeerList().observe(this, { list ->
             supportFragmentManager.beginTransaction().replace(R.id.container, BeerListFragment.newInstance(list))
                     .commit()
         })
     }
}