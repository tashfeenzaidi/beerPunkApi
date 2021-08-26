package com.punkapi.beerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.punkapi.beerapp.R
import com.punkapi.beerapp.adapters.BeerRecyclerViewAdapter
import com.punkapi.beerapp.interfaces.BeerListItemClick
import com.punkapi.beerapp.models.BeerModel

class BeerListFragment : Fragment(), BeerListItemClick {
    private lateinit var list : ArrayList<BeerModel>

    companion object {
        fun newInstance(list : ArrayList<BeerModel>) : BeerListFragment{
            val args = Bundle()
            args.putParcelableArrayList("list",list)
            val fragment = BeerListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
         list = args?.getParcelableArrayList<BeerModel>("list") as ArrayList<BeerModel>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beer_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val adapter = BeerRecyclerViewAdapter(requireContext(),list,this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(index: Int) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,BeerDetailFragment.newInstance(list[index])).addToBackStack("BeerDetail")
            .commit()
    }

}