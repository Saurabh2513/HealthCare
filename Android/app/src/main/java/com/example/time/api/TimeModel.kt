package com.example.realtime.api

import com.google.gson.annotations.SerializedName

data class TimeModel(
    @SerializedName("year"         ) var year         : Int?     = null,
    @SerializedName("month"        ) var month        : Int?     = null,
    @SerializedName("day"          ) var day          : Int?     = null,
    @SerializedName("hour"         ) var hour         : Int?     = null,
    @SerializedName("minute"       ) var minute       : Int?     = null,
    @SerializedName("seconds"      ) var seconds      : Int?     = null,
    @SerializedName("milliSeconds" ) var milliSeconds : Int?     = null,
    @SerializedName("dateTime"     ) var dateTime     : String?  = null,
    @SerializedName("date"         ) var date         : String?  = null,
    @SerializedName("time"         ) var time         : String?  = null,
    @SerializedName("timeZone"     ) var timeZone     : String?  = null,
    @SerializedName("dayOfWeek"    ) var dayOfWeek    : String?  = null,
    @SerializedName("dstActive"    ) var dstActive    : Boolean? = null
)