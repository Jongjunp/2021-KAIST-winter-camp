package com.example.commontask1_pjj

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.TextureView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter
import com.google.gson.Gson

class GenreActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genre_detail)
        var intent = intent

        pieChart = findViewById(R.id.chart_genre)

        initPieChart()

        setPieChart()
    }

    private fun initPieChart(){
        pieChart.setUsePercentValues(false)
        pieChart.description.isEnabled = false
        //pieChart.description.text = "별점 분포"
        //pieChart.description.textSize = 16f

        pieChart.legend.textSize = 20f
    }

    private fun setPieChart(){

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#FFFF00"))
        colors.add(Color.parseColor("#00FF00"))
        colors.add(Color.parseColor("#0000FF"))
        colors.add(Color.parseColor("#8000FF"))

        val xVal = Array<Int>(5) { _ -> 0}

        val genreName = findViewById<View>(R.id.item_genre) as TextView
        genreName.text = intent.getStringExtra("Genre")
        val count = 1

        val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
        val gson = Gson()
        val keys = appSharedPrefs.all.map { it.key }
        val i = keys.iterator()

        while(i.hasNext()){
            var nextKey = i.next()
            var json = appSharedPrefs.getString(nextKey.toString(), "")
            var obj = gson.fromJson(json, ReviewData::class.java)

            if(obj.movieGenre == intent.getStringExtra("Genre")){
                xVal[(obj.movieRating?.toInt() ?: 1) -1] = xVal[(obj.movieRating?.toInt() ?: 1) -1]?.plus(1)
            }
        }

        //data
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(xVal[0].toFloat(), "1"))
        entries.add(PieEntry(xVal[1].toFloat(), "2"))
        entries.add(PieEntry(xVal[2].toFloat(), "3"))
        entries.add(PieEntry(xVal[3].toFloat(), "4"))
        entries.add(PieEntry(xVal[4].toFloat(), "5"))

        val pieDataSet = PieDataSet(entries, "별점")

        pieDataSet.colors = colors
        pieDataSet.sliceSpace = 5f

        val data = PieData(pieDataSet)
        pieChart.data = data
        data.setValueTextSize(20f)

        pieChart.setBackgroundColor(resources.getColor(R.color.white))

        pieChart.animateY(1000)

        pieChart.invalidate()
    }
}