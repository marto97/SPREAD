package com.favoway.spread

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate





class CanvasViewSIR : AppCompatActivity() {

    var dataSets: ArrayList<ILineDataSet> = ArrayList()
    var values: ArrayList<Entry> = ArrayList()

    private val colors = intArrayOf(
        Color.BLUE,
        Color.RED,
        Color.GREEN
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_view_sir)
        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model Simulation"

        actionBar.setDisplayHomeAsUpEnabled(true)


        val susceptibleInt = intent.getIntExtra("susceptibleInt", 1)
        val infectedInt = intent.getIntExtra("infectedInt", 1)
        val recoveredInt = intent.getIntExtra("recoveredInt", 1)
        val durationInt = intent.getIntExtra("durationInt", 1)
        var labelSet:String = ""
        var loopEnd: Int = 100
        for (z in 0..2) {

            when (z) {
                0 -> {
                    labelSet = "Susceptible"
                    loopEnd = susceptibleInt


                }
                1 -> {
                    labelSet = "Infected"
                    loopEnd = infectedInt

                }
                2 -> {
                    labelSet = "Recovered"
                    loopEnd = recoveredInt

                }
                else -> { // Do nothing
                }
            }


            val values: ArrayList<Entry> = ArrayList()
            for (i in 0 until infectedInt) {
                val `val`: Int = (infectedInt-i-1..infectedInt-i+1).random()
                values.add(Entry((i).toFloat(), `val`.toFloat()))
            }

            val d = LineDataSet(values, "$labelSet")
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

        //Description
        val description = Description()
        description.setText("X axis = days, Y axis = number of people")
        description.textSize = 20f
        lineChart.setDescription(description)

        //Legend
        val l: Legend = lineChart.getLegend()
        l.setTextSize(20f);
        l.setTextColor(Color.BLACK);
        l.setForm(Legend.LegendForm.CIRCLE);

    }
}