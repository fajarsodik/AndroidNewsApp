package com.jazastudio.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("everything?q=programmer&apiKey=${BuildConfig.API_KEY}")
    fun getAllNews(): Call<ListNewsReponse>
}