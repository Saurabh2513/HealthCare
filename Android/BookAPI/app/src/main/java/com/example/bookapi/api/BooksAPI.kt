package com.example.bookapi.api

import com.example.bookapi.model.BookResponse
import retrofit2.Response
import retrofit2.http.GET

interface BooksAPI {
    // https://api.itbook.store/1.0/new
    @GET("new")
    suspend fun getProducts():Response<BookResponse>
}