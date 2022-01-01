package com.example.commontask1_pjj

import android.Manifest
import android.Manifest.permission_group.STORAGE
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.transition.Transition
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import org.jetbrains.anko.imageBitmap
import org.jetbrains.anko.spinner
import java.io.ByteArrayOutputStream

class ReviewActivity : AppCompatActivity() {
    private val GALLERY = 1

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceType")
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
            val inputImage = findViewById<View>(R.id.tempView) as ImageView
            val inputTitle = findViewById<View>(R.id.editTitle) as EditText
            val inputReview = findViewById<View>(R.id.editReview) as EditText
            val inputRating = findViewById<View>(R.id.ratingBar) as RatingBar
            val inputGenre = findViewById<View>(R.id.genreSpinner) as Spinner

            val obj = ReviewData()


            val drawable = findViewById<ImageView>(R.id.tempView).getDrawable()
            val bitmapDrawable = drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap
            //bitmap to string
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val bytes = stream.toByteArray()

            obj.movieImage = java.util.Base64.getEncoder().encodeToString(bytes)
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

            //activity 종료
            finish()

        })

    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val tempView = findViewById<ImageView>(R.id.tempView)
        val imageLoader = findViewById<ImageButton>(R.id.imageLoader)

        if( resultCode == Activity.RESULT_OK){
            if( requestCode == GALLERY)
            {
                var ImageData: Uri? = data?.data
                //Toast.makeText(this,ImageData.toString(), Toast.LENGTH_SHORT ).show()
                try{
                    imageLoader.setVisibility(View.INVISIBLE)
                    tempView.setVisibility(View.VISIBLE)
                    Glide.with(this).load(ImageData).into(tempView)
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }
        }
    }

}