package com.punkapi.beerapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.punkapi.beerapp.R
import com.punkapi.beerapp.adapters.BeerRecyclerViewAdapter
import com.punkapi.beerapp.viewModels.BeerListViewModel

class BeerListFragment : Fragment() {

    companion object {
        fun newInstance() = BeerListFragment()
    }

    private lateinit var viewModel: BeerListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beer_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BeerListViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recyclerView: RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view)
        var adapter:BeerRecyclerViewAdapter
        adapter = BeerRecyclerViewAdapter()
        recyclerView.adapter = adapter

    }

}