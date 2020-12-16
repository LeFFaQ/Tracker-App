package com.lffq.trackerapp.ui

import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.lffq.trackerapp.R

class TestModeFragment : Fragment(R.layout.fragment_testmode) {

    val testModeViewModel: TestModeViewModel by navGraphViewModels(R.id.nav_graph)

}