package com.example.mugs_assignment.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mugs_assignment.fragments.Line_graph
import com.example.mugs_assignment.fragments.line_charts_page
import com.example.mugs_assignment.fragments.pie_chart

class MonthDataAdapter(val myContext: Context, fm: FragmentManager, var totalTabs: Int) :
    FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        var bundle = Bundle()
        val frag = line_charts_page()
        if (position == 0) {
            bundle.putInt("no_of_days", 31)
            bundle.putString("name", "Jan")
        }
        else if (position == 1){
            bundle.putInt("no_of_days", 28)
            bundle.putString("name", "Feb")
        }

        else if (position == 2){
            bundle.putInt("no_of_days", 31)
            bundle.putString("name", "Mar")
        }

        else if (position == 3){
            bundle.putInt("no_of_days", 30)
            bundle.putString("name", "Apr")
        }

        else if (position == 4){
            bundle.putInt("no_of_days", 31)
            bundle.putString("name", "May")
        }

        else if (position == 5){
            bundle.putInt("no_of_days", 30)
            bundle.putString("name", "Jun")
        }

        else if (position == 6){
            bundle.putInt("no_of_days", 31)
            bundle.putString("name", "Jul")
        }

        else if (position == 7){
            bundle.putInt("no_of_days", 31)
            bundle.putString("name", "Aug")
        }

        else if (position == 8){
            bundle.putInt("no_of_days", 30)
            bundle.putString("name", "Sep")
        }

        else if (position == 9){
            bundle.putInt("no_of_days", 31)
            bundle.putString("name", "Oct")
        }

        else if (position == 10){
            bundle.putInt("no_of_days", 30)
            bundle.putString("name", "Nov")
        }

        else if (position == 11){
            bundle.putInt("no_of_days", 31)
            bundle.putString("name", "Dec")
        }




        frag.arguments = bundle
        return frag




    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return 12
    }
}