package com.example.iplscoreapi.model





data class InfoX(
    val credits: Int,
    val hitsLimit: Int,
    val hitsToday: Int,
    val hitsUsed: Int,
    val queryTime: Double,
    val s: Int,
    val server: Int
)