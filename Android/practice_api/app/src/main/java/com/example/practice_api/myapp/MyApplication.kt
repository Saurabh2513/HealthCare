package com.example.practice_api.myapp

import android.app.Application
import com.example.practice_api.api.Photo
import com.example.practice_api.repo.ImageRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    // initialize the interface
    private lateinit var photo: Photo

    // initialize repository class
    lateinit var imageRepository: ImageRepository
    override fun onCreate() {
        super.onCreate()
// create Retrofit object
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://fakestoreapiserver.reactbd.com/")
            .build()

        photo = retrofit.create(Photo::class.java)
        imageRepository = ImageRepository(photo)
    }
}