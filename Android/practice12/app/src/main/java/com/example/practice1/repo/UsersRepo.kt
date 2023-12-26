package com.example.practice1.repo

import com.example.practice1.model.User
import com.example.practice1.model.UserPostModel
import com.example.practice1.model.UserPostResponseModel
import com.example.practice1.network.UserServices

class UsersRepo(val userServices: UserServices) : Repo {
    suspend fun getUsers(): List<User> {
        val users = userServices.getUsers().users
        return users!!
    }

    suspend fun addUser(userPostModel : UserPostModel): UserPostResponseModel {
        return userServices.addUser(userPostModel)
    }
}