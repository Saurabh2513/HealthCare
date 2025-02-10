package com.example.bookapi.myapp

import com.example.bookapi.repo.BookRepository
import android.app.Application
import com.example.bookapi.api.BooksAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    private lateinit var booksAPI: BooksAPI
    lateinit var productRepository: BookRepository

    override fun onCreate() {
        super.onCreate()

        // create a retrofit object
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.itbook.store/1.0/")
            .build()

        booksAPI = retrofit.create(BooksAPI::class.java)
        productRepository = BookRepository(booksAPI)
    }
}  