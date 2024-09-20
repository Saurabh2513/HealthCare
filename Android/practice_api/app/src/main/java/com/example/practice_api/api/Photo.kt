package com.example.practice_api.api


import com.example.practice_api.model.ImagesItem
import okhttp3.Response
import retrofit2.http.GET

interface Photo {
    // https://fakestoreapiserver.reactbd.com/photos
    @GET("photos")
     fun getPhotos() : Response<ImagesItem>
}