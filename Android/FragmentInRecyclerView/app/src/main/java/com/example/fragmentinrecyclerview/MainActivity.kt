package com.example.fragmentinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentinrecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var products = ArrayList<Product>()
    lateinit var productAdapter:ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProducts()
        productAdapter=ProductAdapter(products)
        binding.RecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.RecyclerView.adapter=productAdapter
    }

    private fun initProducts() {
       products.add(Product("apple",1000, android.R.drawable.alert_dark_frame))
       products.add(Product("dell",1000,R.drawable.ic_launcher_background))
       products.add(Product("ege",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products.add(Product("apple",1000,R.drawable.ic_launcher_background))
       products

    }

}