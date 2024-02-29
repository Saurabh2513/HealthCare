package com.example.apiretrofit

data class Items(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)