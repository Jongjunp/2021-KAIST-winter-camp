package com.example.commontask1_pjj

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import org.jetbrains.anko.spinner

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
        val completeButton = findViewById<Button>(R.id.complete_button) as Button

        //어댑터 설정
        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.itemList, R.layout.support_simple_spinner_dropdown_item)

        completeButton.setOnClickListener(View.OnClickListener {
            val inputTitle = findViewById<View>(R.id.editTitle) as EditText
            val inputReview = findViewById<View>(R.id.editReview) as EditText
            val inputRating = findViewById<View>(R.id.ratingBar) as RatingBar
            val inputGenre = findViewById<View>(R.id.genreSpinner) as Spinner

            val obj = ReviewData()

            obj.movieTitle = inputTitle.text.toString()
            obj.movieReview = inputReview.text.toString()
            obj.movieRating = inputRating.rating.toString()
            obj.movieGenre = inputGenre.selectedItem.toString()

            val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
            val prefsEditor = appSharedPrefs.edit()
            val gson = Gson()
            val json = gson.toJson(obj)

            prefsEditor.putString(obj.movieTitle, json)
            prefsEditor.commit()

            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()

        })



    }


}