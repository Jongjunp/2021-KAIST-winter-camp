package com.example.commontask1_pjj

import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.gson.Gson

class GenreActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart
    val dataArray = ArrayList<PercentItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genre_detail)
        var intent = intent

        pieChart = findViewById(R.id.chart_genre)

        initPieChart()

        setPieChart()

        addData()

        val rootView = findViewById<RecyclerView>(R.id.genre_recyclerView)
        rootView.layoutManager = LinearLayoutManager(this)
        rootView.adapter = ViewAdapterGenre(this, dataArray)
        rootView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    private fun initPieChart(){
        pieChart.setUsePercentValues(true)

        pieChart.description.isEnabled = false

        pieChart.setDrawEntryLabels(true)
        pieChart.setEntryLabelColor(resources.getColor(R.color.black))
        pieChart.setEntryLabelTextSize(20f)
        val font = ResourcesCompat.getFont(this, R.font.elicedigitalbaeum)
        pieChart.setEntryLabelTypeface(font)

        pieChart.setExtraOffsets(25f, 0f, 25f, 0f)

        pieChart.legend.isEnabled = false
    }

    val yVal = Array<Int>(5) { _ -> 0}

    private fun setPieChart(){

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#FFBF00"))
        colors.add(Color.parseColor("#00FF00"))
        colors.add(Color.parseColor("#0000FF"))
        colors.add(Color.parseColor("#8000FF"))

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

        if(entries.isEmpty())
        {
            val noDataText = findViewById<TextView>(R.id.noData)
            val noDataImage = findViewById<ImageView>(R.id.noData_image)
            val chart = findViewById<com.github.mikephil.charting.charts.PieChart>(R.id.chart_genre)

            chart.visibility = View.INVISIBLE
            noDataImage.visibility = View.VISIBLE
            noDataText.visibility = View.VISIBLE
        }

        val pieDataSet = PieDataSet(entries, "")

        val data = PieData(pieDataSet)
        pieChart.data = data
        data.setValueTextSize(16f)
        val font = ResourcesCompat.getFont(this, R.font.elicedigitalbaeum)
        data.setValueTypeface(font)
        data.setValueFormatter(object : ValueFormatter(){
            override fun getFormattedValue(value: Float): String {
                return "$value%"
            }
        })

        pieDataSet.colors = colors
        pieDataSet.sliceSpace = 5f
        pieDataSet.valueLinePart1Length = 0.5f
        pieDataSet.valueLinePart2Length = 0.3f
        pieDataSet.valueLineWidth = 2f
        pieDataSet.isUsingSliceColorAsValueLineColor = true
        pieDataSet.xValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE



        pieChart.setBackgroundColor(resources.getColor(R.color.white))

        pieChart.animateY(1000,Easing.EaseInOutQuad)

        pieChart.invalidate()
    }

    private fun addData(){
        dataArray.add(PercentItem("1점", yVal[0].toString() + "개"))
        dataArray.add(PercentItem("2점", yVal[1].toString() + "개"))
        dataArray.add(PercentItem("3점", yVal[2].toString() + "개"))
        dataArray.add(PercentItem("4점", yVal[3].toString() + "개"))
        dataArray.add(PercentItem("5점", yVal[4].toString() + "개"))
    }
}