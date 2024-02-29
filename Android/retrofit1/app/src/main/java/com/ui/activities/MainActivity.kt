package com.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Product
import com.example.retrofit1.R
import com.example.retrofit1.myapp.MyApplication
import com.example.retrofit1.network.NetworkResult
import com.example.viewmodel.ProductViewModel
import com.example.viewmodel.ProductViewModelFactory
import com.ui.adapters.ProductAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel
    lateinit var productAdapter: ProductAdapter
    lateinit var recyclerView: RecyclerView
    var arrayList: ArrayList<Product> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.rvmain)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val repository = (application as MyApplication).productRepository
        productViewModel = ViewModelProvider(this, ProductViewModelFactory(repository)).get(
            ProductViewModel::class.java
        )
        productViewModel.getProducts()
        initObserver()

    }

    private fun initObserver() {
        productViewModel.product.observe(this) {
            when (it) {
                is NetworkResult.Loading -> {

                }

                is NetworkResult.Success -> {
                    arrayList.addAll(it.data!!.products)
                    productAdapter = ProductAdapter(this,arrayList)
                    recyclerView.adapter=productAdapter
                }

                is NetworkResult.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }

                else -> {
                    Toast.makeText(this, "data Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}