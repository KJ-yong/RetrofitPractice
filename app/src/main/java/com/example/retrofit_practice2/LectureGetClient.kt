package com.example.retrofit_practice2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LectureGetClient {
    private const val baseUrl = "https://api.hangang.in/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(LectureGetService::class.java)
}