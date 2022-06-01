package com.example.mugs_assignment.adapters

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mugs_assignment.fragments.Line_graph
import com.example.mugs_assignment.fragments.pie_chart

class ViewPagerAdapter (val myContext: Context, fm: FragmentManager, var totalTabs: Int) :
    FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {

            if (position == 0){
                return Line_graph()
            }
            else if (position == 1){
                return pie_chart()
            }
        else {
            return Line_graph()
            }


    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return 2
    }
}