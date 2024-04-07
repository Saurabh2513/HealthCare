package com.example.iplscoreapi.api

import com.example.iplscoreapi.model.SeriesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/v1/series_info")
    suspend fun getSeries(
        @Query("apikey") apikey: String,
        @Query("id") id: String
    ): Response<SeriesModel>
}