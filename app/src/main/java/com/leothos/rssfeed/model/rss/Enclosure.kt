package com.leothos.rssfeed.model.rss

import android.os.Parcelable
import javax.annotation.Generated
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
@Generated("com.robohorse.robopojogenerator")
data class Enclosure(

	@Json(name="link")
	val link: String? = null,

	@Json(name="length")
	val length: Int? = null,

	@Json(name="type")
	val type: String? = null
): Parcelable