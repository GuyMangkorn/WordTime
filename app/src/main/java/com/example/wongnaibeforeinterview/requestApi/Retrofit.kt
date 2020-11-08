package com.example.wongnaibeforeinterview.requestApi

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class Retrofit(private val URL: String) {
    fun getRetrofit() : SideAPI{
        return retrofit2.Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SideAPI::class.java)
    }

    fun getRetrofit2() : TownAPI{
        val client = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build()
        return retrofit2.Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TownAPI::class.java)
    }

}