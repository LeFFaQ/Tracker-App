package com.lffq.trackerapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.lffq.trackerapp.R
import kotlinx.android.synthetic.main.item_list_layout.view.*

class ListViewModel : ViewModel() {


    inner class ContactsAdapter(): RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.MyViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.item_list_layout, parent, false) as RelativeLayout
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: ContactsAdapter.MyViewHolder, position: Int) {
            val titleView = holder.title
            val descriptionView = holder.description
            val distanceView = holder.distance


        }
        override fun getItemCount(): Int { return 5 }

        inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            //Элементы интерфейса
            var title = itemView.title_item
            var description = itemView.description_item
            var distance = itemView.distance_item
            //var date = itemView.


        }
    }
}