package com.jazastudio.newsapp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceCall {

    private var gson: Gson? = null

    open fun makeApiService(backendUrl: String): ApiService {

        if (gson == null) {
            gson = GsonBuilder()
                .setLenient()
                .create()
        }

        val builder = Retrofit.Builder()
            .baseUrl(backendUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))

        val client: OkHttpClient =
            OkHttpClient.Builder()
                .build()

        val apiService = builder.client(client).build()
            .create(ApiService::class.java)
        return apiService
    }

}