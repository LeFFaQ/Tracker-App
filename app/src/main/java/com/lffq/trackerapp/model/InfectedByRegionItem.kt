package com.lffq.trackerapp.model

import com.google.gson.annotations.SerializedName

data class InfectedByRegionItem(

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("isoCode")
	val isoCode: String? = null,

	@field:SerializedName("infected")
	val infected: Int? = null,

	@field:SerializedName("recovered")
	val recovered: Int? = null,

	@field:SerializedName("deceased")
	val deceased: Int? = null
)