package com.example.wongnaibeforeinterview.fragmentNavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.wongnaibeforeinterview.R
import com.example.wongnaibeforeinterview.adapterTime.TabAdapter
import com.example.wongnaibeforeinterview.fragmentTab.AfricaFragment
import com.example.wongnaibeforeinterview.fragmentTab.AmericaFragment
import com.example.wongnaibeforeinterview.fragmentTab.AsiaFragment
import com.example.wongnaibeforeinterview.fragmentTab.EuropeFragment
import com.google.android.material.tabs.TabLayout

class ListFragment : Fragment() {
    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager
    private lateinit var pagerAdapter: TabAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment,container,false)
        super.onCreate(savedInstanceState)
        tabLayout = view.findViewById(R.id.tabLayout_timeZone)
        viewPager = view.findViewById(R.id.viewPager_listTime)
        pagerAdapter = TabAdapter(fragmentManager!!,tabLayout.tabCount)
        viewPager.adapter = pagerAdapter
        //viewPager.offscreenPageLimit = tabLayout.tabCount
        tabLayout.addOnTabSelectedListener(object : TabLayout.TabLayoutOnPageChangeListener(tabLayout),
            TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)!!.select()
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })
        return view
    }
}