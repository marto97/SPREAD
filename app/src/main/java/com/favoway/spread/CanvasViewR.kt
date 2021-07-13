package com.favoway.spread

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CanvasViewR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_view)
        val actionBar = supportActionBar

        actionBar!!.title = "R Model Simulation"

        actionBar.setDisplayHomeAsUpEnabled(true)

        var redPaint: Paint = Paint()
        var greenPaint: Paint = Paint()

        var bluePaint: Paint = Paint()
        //bluePaint.color = Color.argb(0xFF, 0x91, 0xD8, 0xFF)
        bluePaint.color = Color.BLUE
        redPaint.color = Color.RED
        greenPaint.color = Color.GREEN

        val susceptibleInt = intent.getIntExtra("susceptibleInt", 1)
        val infectedInt = intent.getIntExtra("infectedInt", 1)
        val recoveredInt = intent.getIntExtra("recoveredInt", 1)

        var balls: Array<Ball> = arrayOf()

        for(i in 1..susceptibleInt){
            balls += Ball((0..1000).random().toFloat(), (0..1800).random().toFloat(), 1000,1800, bluePaint, "susceptible")
        }
        for(i in 1..infectedInt){
            balls += Ball((0..1000).random().toFloat(), (0..1800).random().toFloat(), 1000,1800, redPaint,"infected")
        }
        for(i in 1..recoveredInt){
            balls += Ball((0..1000).random().toFloat(), (0..1800).random().toFloat(), 1000,1800, greenPaint, "recovered")
        }


        val animationThread = Thread {
            try {
                var startTime: Long
                var endTime: Long
                while (true) {
                    startTime = System.currentTimeMillis()
                    (findViewById<View>(R.id.ball) as BallView).parseBallsData(balls, susceptibleInt, infectedInt, recoveredInt)
                    findViewById<View>(R.id.ball).postInvalidate()
                    endTime = System.currentTimeMillis()
                    var time = 16-(endTime-startTime)
                    if (time>0){
                        Thread.sleep(time)
                    }
                    else{
                        Thread.sleep(2)
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        animationThread.start()


    }
}