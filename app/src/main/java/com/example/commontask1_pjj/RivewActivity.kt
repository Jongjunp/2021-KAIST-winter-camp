package com.example.commontask1_pjj

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
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
        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.itemList, R.layout.support_simple_spinner_dropdown_item)

        //아이템 선택 리스너
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var genreName = spinner.selectedItem.toString()
            }
        }




    }
}