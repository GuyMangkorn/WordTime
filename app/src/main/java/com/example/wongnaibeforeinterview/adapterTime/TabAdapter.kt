package com.example.wongnaibeforeinterview.adapterTime

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.wongnaibeforeinterview.fragmentTab.AfricaFragment
import com.example.wongnaibeforeinterview.fragmentTab.AmericaFragment
import com.example.wongnaibeforeinterview.fragmentTab.AsiaFragment
import com.example.wongnaibeforeinterview.fragmentTab.EuropeFragment

class TabAdapter(fm:FragmentManager,behavior: Int) : FragmentPagerAdapter(fm,behavior){
    private val numTab:Int = behavior
    override fun getCount(): Int {
        return numTab
    }

    override fun getItem(position: Int): Fragment {
        Log.d("TAG_POSITION",position.toString())
        return when(position){
            0 -> AsiaFragment()
            1 -> EuropeFragment()
            2 -> AmericaFragment()
            3 -> AfricaFragment()
            else -> AsiaFragment()
        }
    }
}