package com.example.sarvarkhalmatov_exam_module_5.adapter

import android.content.Context
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sarvarkhalmatov_exam_module_5.R
import com.example.sarvarkhalmatov_exam_module_5.model.Categories
import com.example.sarvarkhalmatov_exam_module_5.model.Restaurants
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class RestaurantAdapter(var context: Context, var items:ArrayList<Restaurants>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant,parent,false)
        return ItemRestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]
        if(holder is ItemRestaurantViewHolder){
            var iv_item_restaurant = holder.iv_item_restaurant
            var tv_title = holder.tv_title
            var tv_text = holder.tv_text
            var rating  = holder.rating

            Picasso.get().load(item.image).into(iv_item_restaurant);
            tv_title.text = item.title
            tv_text.text = item.text
            rating.rating = item.rating.toFloat()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ItemRestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var iv_item_restaurant: ImageView
    var tv_title: TextView
    var tv_text: TextView
    var rating: RatingBar

    init {
        iv_item_restaurant = view.findViewById(R.id.iv_item_restaurant)
        tv_title = view.findViewById(R.id.tv_name_food)
        tv_text = view.findViewById(R.id.tv_address_food)
        rating = view.findViewById(R.id.rating_bar)
    }
}