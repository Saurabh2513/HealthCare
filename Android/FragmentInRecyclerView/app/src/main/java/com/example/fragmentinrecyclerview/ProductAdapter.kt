package com.example.fragmentinrecyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentinrecyclerview.databinding.ProductViewBinding

 class ProductAdapter(var products:ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
 {


    class ProductViewHolder(productView: View):RecyclerView.ViewHolder(productView) {
        var binding = ProductViewBinding.bind(productView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ProductViewHolder {
    var productView = LayoutInflater.from(parent.context).inflate(R.layout.product_view,null)
        return ProductViewHolder(productView)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var product=products[position]
       holder.binding.txtPrice.text = product.price.toString()
        holder.binding.txtTitle.text=product.title
        holder.binding.image.setImageResource(product.image)

    }


    override fun getItemCount(): Int {
        return products.size
    }

}