package com.example.retrofit_practice2


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LectureGetService {
    @GET("lectures")
    suspend fun getLectureList(
        @Query("limit") limit: String,
        @Query("page") page: String
    ): Response<LectureListData>

    @GET("lectures/{id}")
    suspend fun getLectureInfo(@Path("id") id: String): Response<LectureInfoData>
}