package com.lffq.trackerapp.ui

import android.graphics.Color
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
        val pieChart: PieChart = view.findViewById(R.id.pieChart)

        val listPie = ArrayList<PieEntry>().apply {
            add(PieEntry(infected!!, "Заболевшие"))
            add(PieEntry(recovered!!, "Вылечившиеся"))
            add(PieEntry(deceased!!, "Летал. исход"))
        }
        val listColors = ArrayList<Int>().apply {
            add(Color.parseColor("#5c6bc0"))
            add(Color.parseColor("#8e99f3"))
            add(Color.parseColor("#26418f"))
        }

        val pieDataSet = PieDataSet(listPie, null).apply {
            colors = listColors
        }
        val pieData = PieData(pieDataSet).apply {
            setValueTextSize(14f)
            setValueTextColor(Color.WHITE)
        }
        pieChart.apply {
            pieChart.data = pieData
            pieChart.setUsePercentValues(false)

            setEntryLabelColor(Color.WHITE)
            setEntryLabelTextSize(10f)

            setTouchEnabled(false)
            rotationAngle = 30f
            isRotationEnabled = false

            isDrawHoleEnabled = true
            setHoleColor(Color.TRANSPARENT)
            transparentCircleRadius = 45f

            legend.isEnabled = false
            description.isEnabled = false

            animateY(1000, Easing.EaseInOutQuad)
        }

    }

}