package com.example.commontask1_pjj

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    private val GALLERY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_detail)

        //스피너 선언
        val spinner = findViewById<Spinner>(R.id.genreSpinner)

        //어댑터 설정



    }
}