package com.jazastudio.newsapp

import com.google.gson.annotations.SerializedName

data class ListNewsReponse(
    @SerializedName("status")
    var status: String?,

    @SerializedName("totalResults")
    var totalResults: Int?,

    @SerializedName("articles")
    var articles: List<NewsData>
)