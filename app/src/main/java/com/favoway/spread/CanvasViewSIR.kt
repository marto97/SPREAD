package com.favoway.spread

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anychart.AnyChartView
import com.anychart.core.annotations.Line
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import java.security.KeyStore
import java.util.Random

class CanvasViewSIR : AppCompatActivity() {

    lateinit var linelist:ArrayList<Entry>
    lateinit var linelist2:ArrayList<Entry>
    lateinit var lineDataSet:LineDataSet
    lateinit var lineData:LineData
    lateinit var lineDataSet2:LineDataSet
    lateinit var lineData2:LineData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_view_sir)
        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model Simulation"

        actionBar.setDisplayHomeAsUpEnabled(true)

        linelist= ArrayList()
        linelist.add(Entry(10f,100f))
        linelist.add(Entry(20f,300f))
        linelist.add(Entry(30f,200f))
        linelist.add(Entry(40f,600f))
        linelist.add(Entry(50f,500f))
        linelist.add(Entry(60f,900f))

        linelist2= ArrayList()
        linelist2.add(Entry(20f,900f))
        linelist2.add(Entry(30f,650f))
        linelist2.add(Entry(40f,430f))
        linelist2.add(Entry(50f,320f))
        linelist2.add(Entry(60f,200f))
        linelist2.add(Entry(70f,0f))

        lineDataSet = LineDataSet(linelist, "Infected")
        lineDataSet2 = LineDataSet(linelist2, "Susceptible")
        lineData = LineData(lineDataSet2)
        lineData2 = LineData(lineDataSet)

        val lineChart = findViewById<View>(R.id.line_chart) as LineChart

        lineChart.data = lineData

        lineDataSet.setColors(Color.RED)
        lineDataSet.valueTextColor=Color.BLUE
        lineDataSet.valueTextSize = 20f

        lineDataSet2.setColors(Color.BLUE)
        lineDataSet2.valueTextColor=Color.BLUE
        lineDataSet2.valueTextSize = 20f


    }
}