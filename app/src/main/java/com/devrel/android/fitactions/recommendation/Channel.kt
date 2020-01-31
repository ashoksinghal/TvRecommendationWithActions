package com.example.myapplication

data class Channel(
    val channel_id: String,
    val channel_logo: String,
    val channel_number: String,
    val genres__id: String,
    val genres__name: String,
    val is_adult: Boolean,
    val station_id: String,
    val title: String
)