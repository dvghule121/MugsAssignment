package com.example.mugs_assignment.dataset

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.RadarData
import kotlin.random.Random

class Dataset {



    fun createDataset(array: List<Entry>, no_of_days:Int): MutableList<Entry> {
        val array =  array.toMutableList()
        for (i in 0..no_of_days){

          array.add( Entry(i.toFloat(), Random.nextInt(5,8).toFloat()))

        }
        return array
    }








}