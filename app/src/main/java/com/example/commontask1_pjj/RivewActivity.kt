package com.example.commontask1_pjj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

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



    }
}