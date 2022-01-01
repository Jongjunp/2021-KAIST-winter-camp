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
import com.github.mikephil.charting.animation.Easing
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
        //pieChart.description.textSize = 16f
        //pieChart.centerText = "Ratings"
        //pieChart.setCenterTextSize(20f)

        pieChart.setDrawEntryLabels(true)
        pieChart.setEntryLabelColor(resources.getColor(R.color.black))
        pieChart.setEntryLabelTextSize(20f)

        //pieChart.holeRadius = 30f
        //pieChart.transparentCircleRadius = 40f

        pieChart.setExtraOffsets(25f, 0f, 25f, 0f)

        //pieChart.legend.textSize = 20f
        pieChart.legend.isEnabled = false
    }

    private fun setPieChart(){

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#FFBF00"))
        colors.add(Color.parseColor("#00FF00"))
        colors.add(Color.parseColor("#0000FF"))
        colors.add(Color.parseColor("#8000FF"))

        val yVal = Array<Int>(5) { _ -> 0}

        val genreName = findViewById<View>(R.id.item_genre) as TextView
        genreName.text = intent.getStringExtra("Genre") + "영화 별점분포"

        val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
        val gson = Gson()
        val keys = appSharedPrefs.all.map { it.key }
        val i = keys.iterator()

        while(i.hasNext()){
            var nextKey = i.next()
            var json = appSharedPrefs.getString(nextKey.toString(), "")
            var obj = gson.fromJson(json, ReviewData::class.java)

            if(obj.movieGenre == intent.getStringExtra("Genre")){
                yVal[(obj.movieRating?.toInt() ?: 1) -1] = yVal[(obj.movieRating?.toInt() ?: 1) -1]?.plus(1)
            }
        }

        //data
        val entries = ArrayList<PieEntry>()

        for(i: Int in 0..4)
        {
            if(yVal[i]!= 0)
            {
                entries.add(PieEntry(yVal[i].toFloat(), (i+1).toString() + "점"))
            }
        }


        val pieDataSet = PieDataSet(entries, "")

        pieDataSet.colors = colors
        pieDataSet.sliceSpace = 5f
        pieDataSet.valueLinePart1Length = 0.6f
        pieDataSet.valueLinePart2Length = 0.3f
        pieDataSet.valueLineWidth = 2f
        pieDataSet.isUsingSliceColorAsValueLineColor = true
        pieDataSet.xValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE

        val data = PieData(pieDataSet)
        pieChart.data = data
        data.setValueTextSize(20f)

        pieChart.setBackgroundColor(resources.getColor(R.color.white))

        pieChart.animateY(1000,Easing.EaseInOutQuad)

        pieChart.invalidate()
    }
}