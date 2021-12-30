package com.example.commontask1_pjj

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewAdapterB(val context: Context, val dataArray: ArrayList<dataVo>) : RecyclerView.Adapter<ViewHolderB>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderB {
        return ViewHolderB(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return dataArray.size
    }

    override fun onBindViewHolder(holder: ViewHolderB, position: Int) {
        val item = dataArray[position]
        holder.bind(item)
    }
}