package com.example.wongnaibeforeinterview.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.wongnaibeforeinterview.adapterTime.TimeObject
import com.example.wongnaibeforeinterview.requestApi.SideAPI
import retrofit2.Call

class TimeRepository{
    lateinit var dataSource: TimeDataSource
    fun fetchTimeSide(side:String) : LiveData<ArrayList<String>>{
        Log.d("TAG_REQUEST",side)
        dataSource = TimeDataSource()
        dataSource.timeSideDataSource(side)
        return  dataSource.arrResponse
    }
    fun fetTimeDetailData(side:String) : LiveData<ArrayList<TimeObject>>{
        dataSource = TimeDataSource()
        dataSource.timeSideDataSource(side)
        return  dataSource.arrDataResponse

    }
}
