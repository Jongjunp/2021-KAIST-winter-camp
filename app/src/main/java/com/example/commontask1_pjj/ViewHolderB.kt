package com.example.commontask1_pjj

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//뷰의 각 요소 관리
class ViewHolderB(view: View) : RecyclerView.ViewHolder(view) {
    var v_photo: ImageView=view.findViewById(R.id.item_photo)

    //data setting
    fun bind(dataArray: dataVo){
        val imageBytes = Base64.decode(dataArray.photo,0)
        val bitMapImage = BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.size)
        v_photo.setImageBitmap(bitMapImage)
    }
}