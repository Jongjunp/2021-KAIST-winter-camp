package com.example.commontask1_pjj

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewAdapterC(val context: Context, val dataArray: ArrayList<genreItem>) : RecyclerView.Adapter<ViewHolderC>() {

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    private lateinit var mListener: onItemClickListener

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderC {
        return ViewHolderC(LayoutInflater.from(context).inflate(R.layout.genre_list, parent, false), mListener)

    }

    override fun getItemCount(): Int {
        return dataArray.size
    }

    override fun onBindViewHolder(holder: ViewHolderC, position: Int) {
        val item = dataArray[position]
        holder.bind(item)
    }
}