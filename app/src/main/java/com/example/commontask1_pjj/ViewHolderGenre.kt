package com.example.commontask1_pjj

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderGenre(view: View) : RecyclerView.ViewHolder(view) {
    var v_starcount: TextView =view.findViewById(R.id.starCount)
    var v_cnt: TextView =view.findViewById(R.id.cnt)

    //data setting
    fun bind(dataArray: PercentItem){
        v_starcount.text = dataArray.starCount
        v_cnt.text = dataArray.cnt
    }
}