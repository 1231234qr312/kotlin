package com.example.marketproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyItem (var Object:String, var address:String, var price:String, var liken:Int, var chatn:Int, var opicture:Int, var detail: String, var name:String):
    Parcelable {
}