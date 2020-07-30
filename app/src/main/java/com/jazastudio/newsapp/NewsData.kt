package com.jazastudio.newsapp

import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("source")
    var source: SourceData,

    @SerializedName("author")
    var author: String?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("url")
    var url: String?,

    @SerializedName("urlToImage")
    var urlToImage: String?,

    @SerializedName("published")
    var published: String?,

    @SerializedName("content")
    var content: String?
) {
    data class SourceData(
        @SerializedName("id")
        var id: String?,

        @SerializedName("name")
        var name: String?
    )
}