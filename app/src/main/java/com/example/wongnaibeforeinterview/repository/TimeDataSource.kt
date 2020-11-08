package com.example.wongnaibeforeinterview.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wongnaibeforeinterview.adapterTime.TimeObject
import com.example.wongnaibeforeinterview.requestApi.Retrofit
import com.example.wongnaibeforeinterview.requestApi.SideAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TimeDataSource {
    private val arr:MutableLiveData<ArrayList<String>> = MutableLiveData()
    private val arrData:MutableLiveData<ArrayList<TimeObject>> = MutableLiveData()
    val arrDataResponse:LiveData<ArrayList<TimeObject>>
        get() = arrData
    val arrResponse:LiveData<ArrayList<String>>
        get() = arr
    fun timeSideDataSource(side:String){
        GlobalScope.launch(Dispatchers.IO) {
            Retrofit("http://worldtimeapi.org/api/timezone/").getRetrofit().getSideData(side).enqueue(object : Callback<ArrayList<String>> {
                override fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {
                    Observable.just(response.body())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe {
                                arr.postValue(it)
                            }
                    timeDetailData(response.body()!!)
                }
                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                }
            })
        }


    }
    private var arrDataAdd:ArrayList<TimeObject> = ArrayList()
    private var count:Int = 0
    fun timeDetailData(arr:ArrayList<String>){
        for(msg in arr) {
            GlobalScope.launch(Dispatchers.IO) {
                Retrofit("http://worldtimeapi.org/api/timezone/").getRetrofit2().getTownData(msg).enqueue(object : Callback<TimeObject> {
                    override fun onResponse(call: Call<TimeObject>, response: Response<TimeObject>) {
                        ++count
                        Log.d("TAG_REQUEST","${response.body()!!.utc_datetime} , $count , ${arr.size}")
                        arrDataAdd.add(response.body()!!)
                        if(count == arr.size) {
                            Observable.just(arrDataAdd)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe {
                                        arrData.postValue(it)
                                    }
                        }
                    }
                    override fun onFailure(call: Call<TimeObject>, t: Throwable) {}
                })
            }
        }
    }

}