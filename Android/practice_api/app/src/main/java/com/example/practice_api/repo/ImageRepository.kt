package com.example.practice_api.repo

import com.example.practice_api.api.Photo
import com.example.practice_api.model.ImagesItem
import com.example.practice_api.network.NetworkResult

class ImageRepository(private val photo: Photo) {
    suspend fun getPhoto(): NetworkResult<ImagesItem> {
        val response = photo.getPhotos()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }
}