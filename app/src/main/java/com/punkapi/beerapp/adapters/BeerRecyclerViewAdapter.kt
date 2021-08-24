package com.punkapi.beerapp.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.punkapi.beerapp.R

class BeerRecyclerViewAdapter(private val dataSet: Array<String>) :
        RecyclerView.Adapter<BeerRecyclerViewAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val tagTextView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            nameTextView = view.findViewById(R.id.name)
            tagTextView = view.findViewById(R.id.tag_line)
            imageView = view.findViewById(R.id.beer_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.beer_list_single_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageURI(Uri.parse("https://images.punkapi.com/v2/194.png"))
        holder.nameTextView.text = "name"
        holder.tagTextView.text = "tag"
    }

    override fun getItemCount(): Int {
        return 10;
    }
}