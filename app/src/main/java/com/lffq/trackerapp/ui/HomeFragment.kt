package com.lffq.trackerapp.ui

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.lffq.trackerapp.R
import com.lffq.trackerapp.network.RepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    val homeViewModel: HomeViewModel by navGraphViewModels(R.id.nav_graph)
    val repository = RepositoryProvider.provideSearchRepository()

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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