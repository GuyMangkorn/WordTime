package com.example.wongnaibeforeinterview.adapterTime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wongnaibeforeinterview.R


class TimeAdapter (private val context:Context,private val result:ArrayList<String>) : RecyclerView.Adapter<TimeAdapter.Holder>(){
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val timeText:TextView = itemView.findViewById(R.id.timeText)
        fun set(position: Int){
            timeText.text = result[position]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_time,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.set(position)
    }

    override fun getItemCount(): Int {
        return result.size
    }
}