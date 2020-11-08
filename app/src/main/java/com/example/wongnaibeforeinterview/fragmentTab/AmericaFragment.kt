package com.example.wongnaibeforeinterview.fragmentTab

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wongnaibeforeinterview.R


class AmericaFragment : Fragment() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.america_fragment,container,false)
        recyclerView = view.findViewById(R.id.recyclerView_americaTime)
        layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        return view
    }

}