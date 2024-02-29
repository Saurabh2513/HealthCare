package com.example.apiretrofit.model.data

import com.example.apiretrofit.Items
import com.example.apiretrofit.Product
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("/products")
    fun getData(): Call<List<Product>>
}