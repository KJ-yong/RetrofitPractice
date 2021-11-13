package com.example.retrofit_practice2

const val LIMIT_IN_PAGE = 10

class LectureGetRepository {
    suspend fun loadLectureList(page: Int): ArrayList<Lecture>? {
        var response =
            LectureGetClient.service.getLectureList(LIMIT_IN_PAGE.toString(), page.toString())
        return response.body()?.result
    }

    suspend fun loadLectureInfo(id: Int): LectureInfoData? {
        var response = LectureGetClient.service.getLectureInfo(id.toString())
        return response.body()
    }
}