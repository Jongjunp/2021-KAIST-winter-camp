package com.example.commontask1_pjj

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
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
        //var chartGengre = view.findViewById<BarChart>(R.id.chart_genre)
        //setChart(chartGengre)
    }

    private fun initPieChart(){
        pieChart.setUsePercentValues(false)
        pieChart.description.text = "별점"
        pieChart.description.textSize = 16f
    }

    fun setPieChart(){

        //data
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(2f, "1"))
        entries.add(PieEntry(3f, "2"))
        entries.add(PieEntry(7f, "3"))
        entries.add(PieEntry(8f, "4"))
        entries.add(PieEntry(2f, "5"))

        val pieDataSet = PieDataSet(entries, "개수")

        pieDataSet.color = resources.getColor(R.color.teal_700)
        pieDataSet.sliceSpace = 5f

        val data = PieData(pieDataSet)
        pieChart.data = data
        data.setValueTextSize(20f)

        pieChart.setBackgroundColor(resources.getColor(R.color.white))

        pieChart.animateY(2000)

        pieChart.invalidate()
    }

    /*
    private fun setChartView(view: View){
        var chartGenre = view.findViewById<BarChart>(R.id.chart_genre)
        setChart(chartGenre)
    }

    private fun initBarDataSet(barDataSet: BarDataSet){
        barDataSet.formSize = 15f
        barDataSet.setDrawValues(true)
        barDataSet.valueTextSize = 12f
    }

    private fun setChart(barChart: BarChart){
        initBarChart(barChart)

        barChart.setScaleEnabled(false)

        val valueList = ArrayList<Int>()
        val entries : ArrayList<BarEntry> = ArrayList()
        val title = "평가"

        //input
        valueList.add(2)
        valueList.add(1)
        valueList.add(7)
        valueList.add(6)
        valueList.add(3)

        for(i in 0 until valueList.size){
            val barEntry = BarEntry(i.toFloat(), valueList[i].toFloat())
            entries.add(barEntry)
        }

        val barDataSet = BarDataSet(entries, title)
        val data = BarData(barDataSet)
        barChart.data = data
        barChart.invalidate()
    }

    private fun initBarChart(barChart: BarChart){
        barChart.setDrawGridBackground(false)
        barChart.setDrawBarShadow(false)
        barChart.setDrawBorders(false)

        val description = Description()
        barChart.animateY(1000)
        barChart.animateX(1000)
    }*/
}