package com.base.common.util.http

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class ObjectBean(val a: String, val b: String?, val c: ArrayList<String>)

@Parcelize
data class ParcelableBean(val a: String, val b: String?, val c: ArrayList<String>, val d: ParcelableBean2) : Parcelable

@Parcelize
data class ParcelableBean2(val a: String, val b: String?) : Parcelable

data class SerializableBean(val a: String, val b: String?, val c: ArrayList<String>) : Serializable