package com.example.commontask1_pjj

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class ReviewActivity : AppCompatActivity() {
    private val GALLERY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_detail)

        val imageButton = findViewById<ImageButton>(R.id.imageLoader)
        imageButton.setOnClickListener{
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,GALLERY)
        }

        //movieReviewLayout 관련 변수 선언
        val spinner = findViewById<Spinner>(R.id.genreSpinner)
        val complete_button = findViewById<Button>(R.id.complete_button)


        //어댑터 설정
        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.itemList, R.layout.support_simple_spinner_dropdown_item)

    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val tempView = findViewById<ImageView>(R.id.tempView)

        if( resultCode == Activity.RESULT_OK){
            if( requestCode == GALLERY)
            {
                var ImageData: Uri? = data?.data
                Toast.makeText(this,ImageData.toString(), Toast.LENGTH_SHORT ).show()
                try{
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                    tempView.setImageBitmap(bitmap)
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }
        }
    }
}