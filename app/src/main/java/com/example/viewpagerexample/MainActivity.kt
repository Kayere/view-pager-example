package com.example.viewpagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val words = arrayListOf(
            "One",
            "Two",
            "Three",
            "Four",
            "Five"
        )
        val pager = findViewById<ViewPager2>(R.id.pager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        pager.adapter = PagerAdapter(this, words)
//        pager.orientation = ViewPager2.ORIENTATION_VERTICAL
        TabLayoutMediator(tabLayout, pager) {tab, position ->
            tab.text = "${position + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Tab ${tab?.text} selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Tab ${tab?.text} unselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Tab ${tab?.text} reselected", Toast.LENGTH_SHORT).show()
            }
        })
    }
}