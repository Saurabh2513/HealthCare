package com.example.apiretrofit.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofit.Items
import com.example.apiretrofit.Product
import com.example.apiretrofit.databinding.ActivityMainBinding
import com.example.apiretrofit.model.data.ApiInterface
import com.example.apiretrofit.viewmodel.adapters.ProductAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// ... (imports)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: ProductAdapter
    lateinit var recyclerviewMain: RecyclerView
    var BASE_URL = "https://dummyjson.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerviewMain = binding.recyclerviewMain
        recyclerviewMain.layoutManager = LinearLayoutManager(this)

        getAllData()
    }

    private fun getAllData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData = retrofit.getData()

        retroData.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                Log.d("AAAAAAAAAAAAAAAA",response.message().toString())

                var data = response.body()!!
                productAdapter = ProductAdapter(baseContext, data)
                recyclerviewMain.adapter = productAdapter
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("AAAAAAAAAAAAAAAA",t.message!!)
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
