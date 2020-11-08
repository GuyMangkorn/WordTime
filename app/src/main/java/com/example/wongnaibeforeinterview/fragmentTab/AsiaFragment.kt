package com.example.wongnaibeforeinterview.fragmentTab

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wongnaibeforeinterview.R
import com.example.wongnaibeforeinterview.adapterTime.TimeAdapter
import com.example.wongnaibeforeinterview.repository.TimeRepository
import com.example.wongnaibeforeinterview.viewModel.TimeViewModel

class AsiaFragment : Fragment(){
    private lateinit var recyclerView:RecyclerView
    private lateinit var recyclerAdapter:RecyclerView.Adapter<*>
    private lateinit var layoutManager:RecyclerView.LayoutManager
    private lateinit var viewModel:TimeViewModel
    private val repository:TimeRepository = TimeRepository()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.asia_fragment,container,false)
        recyclerView = view.findViewById(R.id.recyclerView_asiaTime)
        layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        viewModel = getViewModel()
        viewModel.fetchTimeDataAsia.observe(requireActivity(),{
            recyclerAdapter = TimeAdapter(requireContext(),it)
            recyclerView.adapter = recyclerAdapter
            recyclerAdapter.notifyDataSetChanged()
        })
        return view

    }
    private fun getViewModel() : TimeViewModel{
        return ViewModelProviders.of(requireActivity(), object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TimeViewModel(repository) as T
            }
        })[TimeViewModel::class.java]
    }

}