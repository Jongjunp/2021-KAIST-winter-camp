package com.example.commontask1_pjj

import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Base64
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.find

//뷰의 각 요소 관리
class ViewHolderB(view: View) : RecyclerView.ViewHolder(view) {
    var photoButton: ImageButton = view.findViewById(R.id.item_photo)
    var titleText: TextView = view.findViewById(R.id.item_title)

    //data setting
    fun bind(dataArray: dataVo) {
        val imageBytes = Base64.decode(dataArray.photo, 0)
        val titleBytes = dataArray.title
        val bitMapImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        photoButton.setImageBitmap(bitMapImage)
        titleText.setText(titleBytes)
    }

}