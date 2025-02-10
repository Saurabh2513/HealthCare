package com.example.apifetchingbyjson.onboarding.ui.model

import com.google.gson.annotations.SerializedName

class UserResponse(
    @SerializedName("page")
    var pageNumber : Int,
    @SerializedName("total_pages")
    var totalPages : Int,
    @SerializedName("data")
    var users : ArrayList<User>
)