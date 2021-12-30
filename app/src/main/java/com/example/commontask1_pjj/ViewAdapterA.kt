package com.example.commontask1_pjj

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewAdapterA(val context: Context, val dataArray: ArrayList<ListItem>) : RecyclerView.Adapter<ViewHolderA>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderA {
        return ViewHolderA(LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dataArray.size
    }

    override fun onBindViewHolder(holder: ViewHolderA, position: Int) {
        val item = dataArray[position]
        holder.bind(item)
    }
}