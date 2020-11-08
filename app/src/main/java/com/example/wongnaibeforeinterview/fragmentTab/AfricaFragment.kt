package com.example.wongnaibeforeinterview.fragmentTab

import android.os.Bundle
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

class AfricaFragment : Fragment(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var viewModel: TimeViewModel
    private val repository:TimeRepository = TimeRepository()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.africa_fragment,container,false)
        recyclerView = view.findViewById(R.id.recyclerView_africaTime)
        layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        viewModel = getViewModel()
        viewModel.fetchTimeDataAfrica.observe(requireActivity(),{
            adapter = TimeAdapter(requireContext(),it)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
        return view
    }

    private fun getViewModel(): TimeViewModel {
        return ViewModelProviders.of(requireActivity(),object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TimeViewModel(repository) as T
            }
        }).get(TimeViewModel::class.java)
    }

}