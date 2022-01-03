package com.example.commontask1_pjj

import android.content.Intent
import android.view.OrientationEventListener
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewHolderC(view: View, listener: ViewAdapterC.onItemClickListener) : RecyclerView.ViewHolder(view) {
    var v_genre: TextView =view.findViewById(R.id.item_genre)

    //data setting
    fun bind(dataArray: genreItem){
        v_genre.text = dataArray.genre
    }

    init {
        itemView.setOnClickListener {
            listener.onItemClick(absoluteAdapterPosition)
        }
    }

}