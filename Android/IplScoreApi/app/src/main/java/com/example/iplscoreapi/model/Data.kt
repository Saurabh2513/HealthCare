package com.example.iplscoreapi.model




data class Data(
    val info: Info,
    val matchList: List<Match>,
    val teamInfo:List<TeamInfo>
)