package com.example.realtime.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.sql.Time

interface TimeInterface {
    @GET("/api/Time/current/zone?")
    @Headers("Accept: application/json")
     fun getTime(
        @Query("timeZone") timeZone: String = "Asia/Kolkata"): Call<TimeModel>

}