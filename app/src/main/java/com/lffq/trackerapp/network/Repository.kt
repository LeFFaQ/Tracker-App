package com.lffq.trackerapp.network

import com.lffq.trackerapp.model.CountryModel
import com.lffq.trackerapp.model.RegionsModel
import io.reactivex.Observable

class Repository(val covidApi: CovidApi) {

    //Get countrys
    fun country(): Observable<CountryModel> {
        return covidApi.allCountrys()
    }

    //More about country
    fun countyInfo(id: String): Observable<RegionsModel> {
        return covidApi.getCountry(id)
    }
}