package com.punkapi.beerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.punkapi.beerapp.R
import com.punkapi.beerapp.models.BeerModel

private const val ARG_PARAM1 = "beer_model"

class BeerDetailFragment : Fragment() {
    private lateinit var beer: BeerModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            beer = it.getParcelable(ARG_PARAM1)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beer_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView:ImageView = view.findViewById(R.id.image)
        val back:ImageView = view.findViewById(R.id.back)
        val name:TextView = view.findViewById(R.id.name)
        val tagLine:TextView = view.findViewById(R.id.tag_line)
        val description:TextView = view.findViewById(R.id.description)
        val abv:TextView = view.findViewById(R.id.abv)

        back.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        Glide.with(requireContext())
            .load(beer.imageUrl)
            .into(imageView)

        name.text = beer.name
        tagLine.text = beer.tagline
        description.text = beer.description
        abv.text = beer.abv.toString()

    }

    companion object {

        @JvmStatic
        fun newInstance(beer:BeerModel) =
            BeerDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1,beer)
                }
            }
    }
}