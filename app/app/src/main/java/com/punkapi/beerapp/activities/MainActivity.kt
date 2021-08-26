package com.punkapi.beerapp.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.punkapi.beerapp.R
import com.punkapi.beerapp.fragments.BeerListFragment
import com.punkapi.beerapp.viewModels.BeerListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<BeerListViewModel>()

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
                viewModel.getSearchResults(p0.toString())
            }
        })

        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 1){
                searchField.visibility = View.GONE
            }else{
                searchField.visibility = View.VISIBLE
            }
        }

        getBeerList()
    }

     private fun getBeerList(){
//         viewModel = ViewModelProvider(this).get(BeerListViewModel::class.java)
         viewModel.getBeerList().observe(this, { list ->
             supportFragmentManager.beginTransaction().replace(R.id.container, BeerListFragment.newInstance(list))
                     .commit()
         })
     }
}