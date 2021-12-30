package com.example.commontask1_pjj

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//뷰의 각 요소 관리
class ViewHolderB(view: View) : RecyclerView.ViewHolder(view) {
    var v_name: TextView=view.findViewById(R.id.item_name)
    var v_photo: ImageView=view.findViewById(R.id.item_photo)

    //data setting
    fun bind(dataArray: dataVo){
        v_name.text = dataArray.name
        v_photo.setImageDrawable(dataArray.photo)
    }
}