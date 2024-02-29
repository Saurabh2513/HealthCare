package com.example.api

import com.example.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface ProductsAPI {
    @GET("products")
    suspend fun getProducts():Response<Products>
}