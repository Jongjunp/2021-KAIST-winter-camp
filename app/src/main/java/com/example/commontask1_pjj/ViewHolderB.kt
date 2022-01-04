package com.example.commontask1_pjj

import android.graphics.BitmapFactory
import android.graphics.Outline
import android.os.Build
import android.util.Base64
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

//뷰의 각 요소 관리
class ViewHolderB(view: View) : RecyclerView.ViewHolder(view) {
    var photoButton: ImageView = view.findViewById(R.id.item_photo)
    var titleText: TextView = view.findViewById(R.id.item_title)
    var ratingText: TextView = view.findViewById(R.id.rating)

    //data setting
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(dataArray: DataVo) {
        val imageBytes = Base64.decode(dataArray.photo, 0)
        val titleBytes = dataArray.title
        val bitMapImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        val ratingBytes = dataArray.rating

        photoButton.setImageBitmap(bitMapImage)
        photoButton.outlineProvider = (object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                val radius = 40f
                if (view != null)
                    outline?.setRoundRect(0,0, view.width, view.height, radius)
            }
        })
        photoButton.clipToOutline = true
        titleText.setText(titleBytes)
        ratingText.setText(ratingBytes)

    }

}