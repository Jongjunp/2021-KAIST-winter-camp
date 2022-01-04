package com.example.commontask1_pjj

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewAdapterB(val context: Context, val dataArray: ArrayList<DataVo>) : RecyclerView.Adapter<ViewHolderB>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderB {
        return ViewHolderB(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return dataArray.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolderB, position: Int) {
        val item = dataArray[position]
        holder.bind(item)
        //activity conversion
        holder.photoButton.setOnClickListener{
            val intent = Intent(holder.photoButton.context, GetReviewActivity::class.java)
            intent.putExtra("keyTitle", item.title)
            ContextCompat.startActivity(holder.photoButton.context, intent, null)
        }
    }
}