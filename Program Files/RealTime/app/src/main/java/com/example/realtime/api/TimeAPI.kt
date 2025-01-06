package com.example.realtime.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TimeAPI {
private var retrofit: Retrofit? = null

    fun create(): TimeInterface {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://timeapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(TimeInterface::class.java)
    }
}