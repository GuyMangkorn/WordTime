package com.example.wongnaibeforeinterview.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.wongnaibeforeinterview.adapterTime.TimeObject
import com.example.wongnaibeforeinterview.repository.TimeRepository


class TimeViewModel(private val repository: TimeRepository) : ViewModel() {

     val fetchTimeDataAsia : LiveData<ArrayList<TimeObject>> by lazy{
        repository.fetTimeDetailData("Asia")
    }

    val fetchTimeDataEurope : LiveData<ArrayList<TimeObject>> by lazy{
        repository.fetTimeDetailData("Europe")
    }

    val fetchTimeDataAfrica : LiveData<ArrayList<TimeObject>> by lazy{
        repository.fetTimeDetailData("Africa")
    }

    val fetchTimeDataAmerica : LiveData<ArrayList<TimeObject>> by lazy{
        repository.fetTimeDetailData("America")
    }
}
