package com.example.commontask1_pjj

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter

class GenreActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genre_detail)

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

    fun setPieChart(){

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#FFFF00"))
        colors.add(Color.parseColor("#00FF00"))
        colors.add(Color.parseColor("#0000FF"))
        colors.add(Color.parseColor("#8000FF"))


        //data
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(2f, "1"))
        entries.add(PieEntry(3f, "2"))
        entries.add(PieEntry(7f, "3"))
        entries.add(PieEntry(8f, "4"))
        entries.add(PieEntry(2f, "5"))

        val pieDataSet = PieDataSet(entries, "개수")

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