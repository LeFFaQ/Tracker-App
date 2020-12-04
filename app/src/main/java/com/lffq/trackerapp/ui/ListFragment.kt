package com.lffq.trackerapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lffq.trackerapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_list_layout.*
import java.lang.Exception


class ListFragment : Fragment(R.layout.fragment_list) {

    val listViewModel: ListViewModel by navGraphViewModels(R.id.nav_graph)
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageGalleryAdapter: ImageGalleryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = recycler
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        imageGalleryAdapter = ImageGalleryAdapter(this.context)
        recyclerView.adapter = imageGalleryAdapter
    }


    private inner class ImageGalleryAdapter(val context: Context?): RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageGalleryAdapter.MyViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.item_list_layout, parent, false) as RelativeLayout
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageGalleryAdapter.MyViewHolder, position: Int) {
            val titleView = holder.title
            val descriptionView = holder.description
            val distanceView = holder.distance

            //Вывод текста на экран

        }
        override fun getItemCount(): Int { return 5 }

        inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            //Элементы интерфейса
            var title = title_item
            var description = description_item
            var distance = distance_item
            //var date = itemView.


        }
    }
}