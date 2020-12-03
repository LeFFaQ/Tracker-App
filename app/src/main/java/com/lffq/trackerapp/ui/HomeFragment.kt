package com.lffq.trackerapp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.lffq.trackerapp.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pieChart: PieChart = view.findViewById(R.id.pieChart)

        val listPie = ArrayList<PieEntry>()
        val listColors = ArrayList<Int>()
        listPie.add(PieEntry(20F, "Pass"))
        listColors.add(Color.parseColor("#9c4dcc"))
        listPie.add(PieEntry(50F, "Fail"))
        listColors.add(Color.parseColor("#38006b"))
        listPie.add(PieEntry(30F, "Unanswered"))
        listColors.add(Color.parseColor("#6a1b9a"))

        val pieDataSet = PieDataSet(listPie, "")
        pieDataSet.setColors(listColors)

        val pieData = PieData(pieDataSet)
        pieDataSet.sliceSpace = 3f
        pieData.setValueTextSize(14f)
        pieChart.data = pieData

        pieChart.setUsePercentValues(true)
        pieChart.isDrawHoleEnabled = false
        pieChart.description.isEnabled = false
        pieChart.setEntryLabelColor(Color.TRANSPARENT)

        pieChart.setHoleRadius(30f)
        pieChart.setHoleColor(Color.TRANSPARENT)

        pieChart.legend.isEnabled = false

        pieChart.animateY(1400, Easing.EaseInOutQuad)
    }
}