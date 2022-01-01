package com.example.commontask1_pjj

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class GetReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_review_detail)

        var intent = intent

        val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
        val gson = Gson()
        val keys = appSharedPrefs.all.map { it.key }
        val i = keys.iterator()

        while(i.hasNext()){
            var nextKey = i.next()
            var json = appSharedPrefs.getString(nextKey.toString(), "")
            var obj = gson.fromJson(json, ReviewData::class.java)

            //if(obj.movieImage == intent.getStringExtra("Genre")){

            //}
        }

    }

}