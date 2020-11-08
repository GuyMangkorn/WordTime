package com.example.wongnaibeforeinterview.requestApi

import com.example.wongnaibeforeinterview.adapterTime.TimeObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SideAPI {
    @GET("{side}")
    fun getSideData(
        @Path("side") side: String
    ) : Call<ArrayList<String>>

}

interface TownAPI {
    @GET("{side}")
    suspend fun getTownData(
            @Path("side") side: String
    ) : Call<TimeObject>

}