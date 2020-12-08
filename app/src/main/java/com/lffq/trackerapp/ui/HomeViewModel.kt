package com.lffq.trackerapp.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.lffq.trackerapp.R
import com.lffq.trackerapp.other.Constants
import com.lffq.trackerapp.other.adapterData
import kotlinx.android.synthetic.main.contacts_card.view.*
import kotlinx.android.synthetic.main.covid_card.view.*

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


    inner class CardsAdapter(val context: Context?, var list: ArrayList<adapterData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            if (viewType == Constants.TYPE_STATS) {
                return View1ViewHolder(
                        LayoutInflater.from(context).inflate(R.layout.covid_card, parent, false)
                )
            }
            return View2ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.contacts_card, parent, false)
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            if (list[position].viewType == Constants.TYPE_STATS) {
                (holder as View1ViewHolder).bind(position)
            } else {
                (holder as View2ViewHolder).bind(position)
            }
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun getItemViewType(position: Int): Int {
            return list[position].viewType
        }

        inner class View1ViewHolder(itemView: View) :
                RecyclerView.ViewHolder(itemView) {
            fun bind(position: Int) {
                val recyclerViewModel = list[position]

                itemView.covid_card.setOnClickListener {
                    val action = HomeFragmentDirections.actionHomeFragmentToStatsFragment()
                    itemView.findNavController().navigate(action)
                }
            }
        }
        inner class View2ViewHolder(itemView: View) :
                RecyclerView.ViewHolder(itemView) {
            fun bind(position: Int) {
                val recyclerViewModel = list[position]

                itemView.contacts_card.setOnClickListener {
                    val action = HomeFragmentDirections.actionHomeFragmentToListFragment()
                    itemView.findNavController().navigate(action)
                }
            }
        }
    }
}