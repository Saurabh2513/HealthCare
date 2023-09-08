package com.example.machinetest10.product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.machinetest10.Book
import com.example.machinetest10.R
import com.example.machinetest10.databinding.ProductviewBinding


class BookAdapter(val context: Context, private var products: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding = ProductviewBinding.bind(itemView)
        var book_img : ImageView
        var book_name : TextView

        init {
            book_img = itemView.findViewById(R.id.book_img)
            book_name = itemView.findViewById(R.id.book_name)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.productview, parent, false)
        return BookViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        holder.book_name.text = products[position].title.toString()
        Glide.with(holder.book_img).load(products[position].toString()).into(holder.book_img)

//        holder.binding.bookName.text = products[position].toString()
//        Glide.with(holder.binding.bookImg).load(products[position].toString())
//            .into(holder.binding.bookImg)

    }

    override fun getItemCount(): Int {
        return products.size
    }

}


