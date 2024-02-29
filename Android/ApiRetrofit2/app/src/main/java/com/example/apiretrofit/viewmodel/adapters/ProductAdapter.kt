package com.example.apiretrofit.viewmodel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofit.Items
import com.example.apiretrofit.Product
import com.example.apiretrofit.R

class ProductAdapter(var con: Context, var list: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var thumbnail = v.findViewById<ImageView>(R.id.thumbnail_image)
        var title = v.findViewById<TextView>(R.id.title_text)
        var brand = v.findViewById<TextView>(R.id.brand_text)
        var price = v.findViewById<TextView>(R.id.price_text)
        var description = v.findViewById<TextView>(R.id.description_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(con).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


//        Glide.with(con).load(list[position].thumbnail).into(holder.thumbnail)
//        holder.title.text = list[position].title.toString()
//        holder.brand.text = list[position].brand.toString()
//        holder.price.text = list[position].price.toString()
//        holder.description.text = list[position].description.toString()
    }
}