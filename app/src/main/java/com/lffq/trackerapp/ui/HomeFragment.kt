package com.lffq.trackerapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lffq.trackerapp.R
import com.lffq.trackerapp.network.RepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    val homeViewModel: HomeViewModel by navGraphViewModels(R.id.nav_graph)
    val repository = RepositoryProvider.provideSearchRepository()

    private lateinit var recyclerView: RecyclerView
    private lateinit var cardsAdapter: HomeViewModel.CardsAdapter

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = recycler_home
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        cardsAdapter = homeViewModel.CardsAdapter(this.context)
        recyclerView.adapter = cardsAdapter

        repository.countyInfo("1brJ0NLbQaJKPTWMO")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                homeViewModel.pieChartInit(view, result?.infected, result?.recovered, result?.deceased)
                Log.d("Result", "${result.infected}")
            }, { error ->
                error.printStackTrace()
            })

        covid_layout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToStatsFragment()
            findNavController().navigate(action)
        }

        contact_layout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToListFragment()
            findNavController().navigate(action)
        }

    }

}