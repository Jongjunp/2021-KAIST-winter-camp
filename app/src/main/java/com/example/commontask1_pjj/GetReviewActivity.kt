package com.example.commontask1_pjj

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.util.*
import java.util.Base64.Decoder

class GetReviewActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_review_detail)

        var intent = intent

        val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
        val gson = Gson()
        var json = appSharedPrefs.getString(intent.getStringExtra("keyTitle"), "")
        var obj = gson.fromJson(json, ReviewData::class.java)

        val image = findViewById<View>(R.id.getImage) as ImageView
        val title = findViewById<View>(R.id.getTitle) as TextView
        val review = findViewById<View>(R.id.getReview) as EditText
        val rating = findViewById<View>(R.id.getRatingBar) as RatingBar
        val genre = findViewById<View>(R.id.getGenreSpinner) as Spinner

        val imageByte = Base64.getDecoder().decode(obj.movieImage)
        val bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.size)
        image.setImageBitmap(bitmap)

        title.text = obj.movieTitle
        review.setText(obj.movieReview)
        obj.movieRating?.let { rating.rating = it.toFloat() }

        ArrayAdapter.createFromResource(
            this,
            R.array.itemList,
            R.layout.spinner_layout
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genre.adapter = adapter
        }

        var selectionNum = 0

        selectionNum = when (obj.movieGenre){
            "액션/범죄" -> 0
            "드라마/멜로" -> 1
            "SF/판타지" -> 2
            "코미디" -> 3
            "공포/스릴러" -> 4
            else -> 5
        }

        genre.setSelection(selectionNum)

        val completeButton = findViewById<Button>(R.id.complete_button2) as Button
        val deleteButton = findViewById<Button>(R.id.delete_button) as Button

        completeButton.setOnClickListener(View.OnClickListener {
            val obj2 = ReviewData()

            val drawable = image.getDrawable()
            val bitmapDrawable = drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap
            //bitmap to string
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val bytes = stream.toByteArray()

            obj2.movieImage = java.util.Base64.getEncoder().encodeToString(bytes)
            obj2.movieTitle = title.text.toString()
            obj2.movieReview = review.text.toString()
            obj2.movieRating = rating.rating.toInt().toString()
            obj2.movieGenre = genre.selectedItem.toString()

            val appSharedPrefs2 = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
            val prefsEditor2 = appSharedPrefs2.edit()
            val gson2 = Gson()
            val json2 = gson2.toJson(obj2)

            prefsEditor2.putString(obj2.movieTitle, json2)
            prefsEditor2.commit()

            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()

            //activity 종료
            finish()

        })

        deleteButton.setOnClickListener(View.OnClickListener {

            val appSharedPrefs3 = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
            val prefsEditor3 = appSharedPrefs3.edit()

            prefsEditor3.remove(intent.getStringExtra("keyTitle"))
            prefsEditor3.commit()

            Toast.makeText(this, "Deleted!", Toast.LENGTH_SHORT).show()

            //activity 종료
            finish()
        })
    }

}