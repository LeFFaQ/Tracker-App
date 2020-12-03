package com.lffq.trackerapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.lffq.trackerapp.R
import com.lffq.trackerapp.network.RepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeFragment : Fragment(R.layout.fragment_home) {

    val homeViewModel: HomeViewModel by navGraphViewModels(R.id.nav_graph)
    val repository = RepositoryProvider.provideSearchRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

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


        Log.d(TAG, "onViewCreated")
        //homeViewModel.pieChartInit(view)
    }
}