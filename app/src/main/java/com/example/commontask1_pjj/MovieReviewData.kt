package com.example.commontask1_pjj

import android.graphics.drawable.Drawable
import android.icu.text.CaseMap

data class MovieReviewData(
    val image:Drawable,
    val title:String,
    val review:String,
    val genre:String,
    val rating:Int
)