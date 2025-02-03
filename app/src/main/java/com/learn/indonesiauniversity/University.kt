package com.learn.indonesiauniversity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class University(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
