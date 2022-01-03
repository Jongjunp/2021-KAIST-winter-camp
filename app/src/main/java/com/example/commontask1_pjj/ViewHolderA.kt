package com.example.commontask1_pjj

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//뷰의 각 요소 관리
class ViewHolderA(view: View, listener: ViewAdapterA.onItemClickListener) : RecyclerView.ViewHolder(view) {
    var v_name: TextView=view.findViewById(R.id.item_name)
    var v_phone: TextView=view.findViewById(R.id.item_phone)

    //data setting
    fun bind(dataArray: ListItem){
        v_name.text = dataArray.name
        v_phone.text = dataArray.phone
    }

    init {
        itemView.setOnClickListener {
            listener.onItemClick(absoluteAdapterPosition)
        }
    }
}