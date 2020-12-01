package com.lffq.trackerapp.network

import com.lffq.trackerapp.model.CountryModel
import com.lffq.trackerapp.model.RegionsModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CovidApi {

    @GET("v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST")
    fun allCountrys(@Query("disableRedirect") boolean: Boolean = true): Observable<CountryModel>

    @GET("v2/key-value-stores/{id}/records/LATEST")
    fun getCountry(
        @Path("id") id: String,
        @Query("disableRedirect") boolean: Boolean = true): Observable<RegionsModel>

    companion object Factory {
        fun create(): CovidApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.apify.com/")
                .build()

            return retrofit.create(CovidApi::class.java);
        }
    }
}