package com.example.mugs_assignment.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mugs_assignment.R
import com.example.mugs_assignment.dataset.Dataset
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [line_charts_page.newInstance] factory method to
 * create an instance of this fragment.
 */
class line_charts_page : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_line_charts_page, container, false)
        val bundle = arguments
        var monthDataset = listOf<Entry>()
        var lable = ""
        if (bundle!= null) {
            val no_of_days = bundle.get("no_of_days").toString().toInt()
            lable = bundle.get("name").toString()
            val dataset = Dataset()
            monthDataset = dataset.createDataset(monthDataset,no_of_days).toList()
        }
        val chartView = view.findViewById<LineChart>(R.id.line_chart)
        val lineDataSet = LineDataSet(monthDataset, lable)

        lineDataSet.color = Color.BLUE
        lineDataSet.lineWidth = 3f



        val data = ArrayList<ILineDataSet>()
        data.add(lineDataSet)


        val finalData = LineData(data)


        val XAxis = chartView.xAxis
        XAxis.position = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
        XAxis.enableGridDashedLine(2f, 1f, 0f);
        chartView.axisLeft.axisMaximum = 10f
        chartView.axisLeft.axisMinimum = 0f







        chartView.isDragEnabled = true
        chartView.getAxisRight().setEnabled(false);

        chartView.setTouchEnabled(true)
        chartView.setScaleEnabled(true)
        chartView.description.text = "Monthly expenses"
        chartView.description.textSize = 15f
        chartView.data = finalData

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment line_charts_page.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            line_charts_page().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}