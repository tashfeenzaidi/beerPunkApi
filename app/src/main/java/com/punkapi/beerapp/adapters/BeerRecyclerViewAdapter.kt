package com.punkapi.beerapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.punkapi.beerapp.R
import com.punkapi.beerapp.interfaces.BeerListItemClick
import com.punkapi.beerapp.models.BeerModel

class BeerRecyclerViewAdapter(private val context:Context, var list:ArrayList<BeerModel> ,private val itemClick:BeerListItemClick) :
        RecyclerView.Adapter<BeerRecyclerViewAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.name)
        val tagTextView: TextView = view.findViewById(R.id.tag_line)
        val imageView: ImageView = view.findViewById(R.id.beer_image)
        var view:View = view

        fun onBind( listener:BeerListItemClick){
            view.setOnClickListener {
                listener.onItemClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.beer_list_single_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
                .load(list[position].imageUrl)
                .into(holder.imageView)

        holder.nameTextView.text = list[position].name
        holder.tagTextView.text = list[position].tagline
        holder.onBind(itemClick)
    }

    override fun getItemCount(): Int {
        return if (list.isNotEmpty()){
            list.size
        }else{
            0
        }
    }
}