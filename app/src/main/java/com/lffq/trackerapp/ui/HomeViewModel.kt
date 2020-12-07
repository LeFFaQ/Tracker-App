package com.lffq.trackerapp.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.lffq.trackerapp.R
import com.lffq.trackerapp.other.Constants
import java.lang.IllegalArgumentException

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



    inner class CardsAdapter(val context: Context?): RecyclerView.Adapter<CardsAdapter.BaseViewHolder<*>>() {

        abstract inner class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
            abstract fun bind(item: T)
        }
        private val adapterDataList: List<Any> = emptyList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

            return when (viewType) {
                Constants.TYPE_STATS -> {
                    val view = LayoutInflater.from(context).inflate(R.layout.covid_card, parent, false)
                    StatsViewHolder(view)
                }
                Constants.TYPE_CONTACTS -> {
                    val view = LayoutInflater.from(context).inflate(R.layout.contacts_card, parent, false)
                    ContactsViewHolder(view)
                }
                else -> throw IllegalArgumentException("Invalid view type")
            }

        }

        override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
            val element = adapterDataList[position]
            when (holder) {
                is StatsViewHolder -> holder.bind(element as HomeViewModel)
                is ContactsViewHolder -> holder.bind(element as HomeViewModel)
                else -> throw IllegalArgumentException()
            }
        }

        override fun getItemViewType(position: Int): Int {
            val comparable = data[position]
            return super.getItemViewType(position)
        }

        inner class StatsViewHolder(itemView: View) : BaseViewHolder<Any>(itemView) {

            override fun bind(item: Any) {
                TODO("Not yet implemented")
            }
        }
        inner class ContactsViewHolder(itemView: View) : BaseViewHolder<Any>(itemView)  {

            override fun bind(item: Any) {
                TODO("Not yet implemented")
            }
        }

        override fun getItemCount(): Int {
            return 2
        }

    }

}