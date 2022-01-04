package com.example.commontask1_pjj

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//chart 보이는 activity 별점 list adapter
class ViewAdapterGenre(val context: Context, val dataArray: ArrayList<PercentItem>) : RecyclerView.Adapter<ViewHolderGenre>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGenre {
        return ViewHolderGenre(LayoutInflater.from(context).inflate(R.layout.genre_detail_list, parent, false))
    }

    override fun getItemCount(): Int {
        return dataArray.size
    }

    override fun onBindViewHolder(holder: ViewHolderGenre, position: Int) {
        val item = dataArray[position]
        holder.bind(item)
    }
}