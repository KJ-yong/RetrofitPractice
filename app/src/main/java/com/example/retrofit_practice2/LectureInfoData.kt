package com.example.retrofit_practice2

import com.google.gson.annotations.SerializedName

data class LectureInfoData(
    @SerializedName("id")
    var id : Int,
    @SerializedName("is_scraped")
    var isScraped : Boolean,
    @SerializedName("grade")
    var grade : Int,
    @SerializedName("semester_data")
    var semesterData : ArrayList<String>,
    @SerializedName("top3_hash_tag")
    var top3HashTag: ArrayList<Top3HashTag>,
    @SerializedName("code")
    var code : String,
    @SerializedName("name")
    var name : String,
    @SerializedName("department")
    var department : String,
    @SerializedName("professor")
    var professor : String,
    @SerializedName("classification")
    var classification : String,
    @SerializedName("total_rating")
    var totalRating : Double,
    @SerializedName("last_reviewed_at")
    var lastReviewedAt : String,
    @SerializedName("review_count")
    var reviewCount : Int,
    @SerializedName("is_deleted")
    var isDeleted : Boolean,
    @SerializedName("created_at")
    var createdAt : String,
    @SerializedName("updated_at")
    var updatedAt : String

)
