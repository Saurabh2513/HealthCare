package com.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.Product
import com.example.retrofit1.R
import com.squareup.picasso.Picasso

class ProductAdapter(var con: Context, var product: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.img_thumbnail)
        val title = itemView.findViewById<TextView>(R.id.title_text)
        val price = itemView.findViewById<TextView>(R.id.price_text)
        val description = itemView.findViewById<TextView>(R.id.description_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   // Glide.with(con).load(product[position].images).into(holder.image)
        Glide.with(con).load(product[position]).into(holder.image)
        holder.title.text = product[position].title
        holder.price.text = product[position].price.toString()
        holder.description.text = product[position].description
    }
}