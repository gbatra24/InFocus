package com.android.infocus.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemUpdates(var title: String,
                       var desc: String,
                       var imageRes: Int) : Parcelable {

    companion object {
        const val NO_IMAGE_RES_ID = 0
    }
}