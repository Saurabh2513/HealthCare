package com.example.task2nov.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : UserAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/users")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }
}