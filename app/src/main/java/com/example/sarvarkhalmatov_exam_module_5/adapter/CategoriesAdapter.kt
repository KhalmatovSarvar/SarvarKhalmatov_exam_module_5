package com.example.sarvarkhalmatov_exam_module_5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sarvarkhalmatov_exam_module_5.R
import com.example.sarvarkhalmatov_exam_module_5.model.Categories
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class CategoriesAdapter(var context: Context, var items:ArrayList<Categories>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return ItemCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]
        if(holder is ItemCategoryViewHolder){
            var iv_item_category = holder.iv_item_category
            var tv_title = holder.tv_title

            Picasso.get().load(item.image).into(iv_item_category);
            tv_title.text = item.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ItemCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var iv_item_category: ImageView
    var tv_title: TextView

    init {
        iv_item_category = view.findViewById(R.id.iv_item_category)
        tv_title = view.findViewById(R.id.tv_item_category)
    }
}