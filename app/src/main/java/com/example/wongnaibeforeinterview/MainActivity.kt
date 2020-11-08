package com.example.wongnaibeforeinterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.wongnaibeforeinterview.fragmentNavigation.HomeFragment
import com.example.wongnaibeforeinterview.fragmentNavigation.ListFragment
import com.example.wongnaibeforeinterview.fragmentNavigation.TabFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val homePage:Fragment = HomeFragment()
    private val listPage:Fragment = ListFragment()
    private val tabPage:Fragment = TabFragment()
    private var currentFragment:Fragment = HomeFragment()
    private lateinit var navigation:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = findViewById(R.id.bottomNavigationMain)
        setFragment()
        navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.page_home -> {
                    supportFragmentManager.beginTransaction().hide(currentFragment).show(homePage).commit()
                    currentFragment = homePage
                    true
                }
                R.id.page_list -> {
                    supportFragmentManager.beginTransaction().hide(currentFragment).show(listPage).commit()
                    currentFragment = listPage
                    true
                }
                R.id.page_tab -> {
                    supportFragmentManager.beginTransaction().hide(currentFragment).show(tabPage).commit()
                    currentFragment = tabPage
                    true
                }
                else -> false
            }
        }
    }
    private fun setFragment(){
        supportFragmentManager.beginTransaction().apply {
            add(R.id.frame_fragment,homePage).hide(homePage)
            add(R.id.frame_fragment,listPage).hide(listPage)
            add(R.id.frame_fragment,tabPage).hide(tabPage)
        }.commit()
        navigation.selectedItemId = R.id.page_home
        supportFragmentManager.beginTransaction().show(homePage).commit()
    }
}