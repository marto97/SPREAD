package com.favoway.spread

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate





class CanvasViewSIR : AppCompatActivity() {

    lateinit var linelist:ArrayList<Entry>
    lateinit var linelist2:ArrayList<Entry>
    lateinit var lineDataSet:LineDataSet
    lateinit var lineData:LineData
    lateinit var lineDataSet2:LineDataSet
    lateinit var lineData2:LineData
    var dataSets: ArrayList<ILineDataSet> = ArrayList()
    var values: ArrayList<Entry> = ArrayList()

    private val colors = intArrayOf(
        ColorTemplate.VORDIPLOM_COLORS[0],
        ColorTemplate.VORDIPLOM_COLORS[1],
        ColorTemplate.VORDIPLOM_COLORS[2]
    )

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

        for (z in 0..2) {
            val values: ArrayList<Entry> = ArrayList()
            for (i in 0 until 10) {
                val `val`: Double = Math.random() * 12 + 3
                values.add(Entry(i.toFloat(), `val`.toFloat()))
            }
            val d = LineDataSet(values, "DataSet " + (z + 1))
            d.lineWidth = 2.5f
            d.circleRadius = 4f
            val color: Int = colors.get(z % colors.size)
            d.color = color
            d.setCircleColor(color)
            dataSets.add(d)
        }

        val data = LineData(dataSets)
        //chart.setData(data)

        val lineChart = findViewById<View>(R.id.line_chart) as LineChart

        //lineChart.setData(lineData);
        lineChart.setData(data);

        lineDataSet.setColors(Color.RED)
        lineDataSet.valueTextColor=Color.RED
        lineDataSet.valueTextSize = 20f

        lineDataSet2.setColors(Color.BLUE)
        lineDataSet2.valueTextColor=Color.BLUE
        lineDataSet2.valueTextSize = 20f


    }
}