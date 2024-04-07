package com.example.iplscoreapi.model


data class SeriesModel(
    val apikey: String,
    val `data`: Data,
    val info: InfoX,
    val status: String,
    val teamInfo: TeamInfo
)