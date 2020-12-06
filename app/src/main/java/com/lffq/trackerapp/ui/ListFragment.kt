package com.lffq.trackerapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lffq.trackerapp.R
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(R.layout.fragment_list) {

    val listViewModel: ListViewModel by navGraphViewModels(R.id.nav_graph)

    private lateinit var recyclerView: RecyclerView
    private lateinit var contactsAdapter: ListViewModel.ContactsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = recycler
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        contactsAdapter = listViewModel.ContactsAdapter()
        recyclerView.adapter = contactsAdapter
    }
}