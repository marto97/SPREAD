package com.example.spread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CanvasView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_view)
        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model Simulation"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val susceptibleInt = intent.getIntExtra("susceptibleInt", 1)
        val infectedInt = intent.getIntExtra("infectedInt", 1)

        var ballsPosition: Array<IntArray> = emptyArray()
        for (i in 1..susceptibleInt) {
            ballsPosition += intArrayOf((30..1000).random(), (30..1800).random())
        }


        val animationThread = Thread {
            try {
                var startTime: Long
                var endTime: Long
                while (true) {
                    startTime = System.currentTimeMillis()
                    (findViewById<View>(R.id.ball) as BallView).parseBallsData(susceptibleInt, infectedInt)
                    findViewById<View>(R.id.ball).postInvalidate()
                    endTime = System.currentTimeMillis()
                    Thread.sleep(16 - (endTime - startTime))
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        animationThread.start()
    }
}