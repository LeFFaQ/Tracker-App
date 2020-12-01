package com.lffq.trackerapp.model

import com.google.gson.annotations.SerializedName

data class RegionsModel(

	@field:SerializedName("infected")
	val infected: Int? = null,

	@field:SerializedName("tested")
	val tested: Int? = null,

	@field:SerializedName("recovered")
	val recovered: Int? = null,

	@field:SerializedName("deceased")
	val deceased: Int? = null,

	@field:SerializedName("infectedByRegion")
	val infectedByRegion: List<InfectedByRegionItem?>? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("historyData")
	val historyData: String? = null,

	@field:SerializedName("sourceUrl")
	val sourceUrl: String? = null,

	@field:SerializedName("lastUpdatedAtApify")
	val lastUpdatedAtApify: String? = null,

	@field:SerializedName("lastUpdatedAtSource")
	val lastUpdatedAtSource: String? = null,

	@field:SerializedName("readMe")
	val readMe: String? = null
)