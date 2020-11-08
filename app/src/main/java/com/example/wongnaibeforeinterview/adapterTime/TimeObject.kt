package com.example.wongnaibeforeinterview.adapterTime

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TimeObject(@SerializedName("utc_datetime")
                 @Expose
                val utc_datetime:String,
                 @SerializedName("utc_offset")
                 @Expose
                val utc_offset:String)
