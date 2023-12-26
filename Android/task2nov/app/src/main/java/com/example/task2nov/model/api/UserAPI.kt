package com.example.task2nov.model.api

import com.example.task2nov.model.UsersDetail
import retrofit2.Call
import retrofit2.http.GET

interface UserAPI {

        @GET("users")
        fun getUserDetail(s: String): Call<UsersDetail>

}