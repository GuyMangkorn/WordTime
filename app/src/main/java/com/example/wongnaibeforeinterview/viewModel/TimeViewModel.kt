package com.example.wongnaibeforeinterview.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.wongnaibeforeinterview.repository.TimeRepository


class TimeViewModel(private val repository: TimeRepository) : ViewModel() {

     val fetchTimeDataAsia : LiveData<ArrayList<String>> by lazy{
        repository.fetchTimeSide("Asia")
    }

    val fetchTimeDataEurope : LiveData<ArrayList<String>> by lazy{
        repository.fetchTimeSide("Europe")
    }

    val fetchTimeDataAfrica : LiveData<ArrayList<String>> by lazy{
        repository.fetchTimeSide("Africa")
    }

    val fetchTimeDataAmerica : LiveData<ArrayList<String>> by lazy{
        repository.fetchTimeSide("America")
    }
}
