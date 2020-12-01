package com.lffq.trackerapp.model


data class CountryModel(
	val sourceUrl: String? = null,
	val infected: Int? = null,
	val country: String? = null,
	val recovered: Int? = null,
	val deceased: Int? = null,
	val moreData: String? = null,
	val tested: String? = null,
	val lastUpdatedApify: String? = null,
	val historyData: String? = null
)