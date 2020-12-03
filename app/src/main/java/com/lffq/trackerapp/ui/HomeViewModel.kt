package com.lffq.trackerapp.ui

import android.content.ContentValues.TAG
import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.lffq.trackerapp.R

class HomeViewModel : ViewModel() {

    fun pieChartInit(
        view: View,
        infected: Float?,
        recovered: Float?,
        deceased: Float?
    ) {

        Log.d(TAG, "pieChartInit: ${infected}")
        val pieChart: PieChart = view.findViewById(R.id.pieChart)

        val listPie = ArrayList<PieEntry>()
        val listColors = ArrayList<Int>()

        listPie.add(PieEntry(infected!!, "Заражённые"))
        listColors.add(Color.parseColor("#d81b60"))
        listPie.add(PieEntry(recovered!!, "Вылечившиеся"))
        listColors.add(Color.parseColor("#ff5c8d"))
        listPie.add(PieEntry(deceased!!, "Умершие"))
        listColors.add(Color.parseColor("#a00037"))

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
        pieChart.setUsePercentValues(false)
        pieChart.setHoleColor(Color.TRANSPARENT)

        pieChart.legend.isEnabled = false

        pieChart.animateY(1400, Easing.EaseInOutQuad)
    }

}