package com.favoway.spread

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CanvasViewR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_view)
        val actionBar = supportActionBar

        actionBar!!.title = "R Simulation"

        actionBar.setDisplayHomeAsUpEnabled(true)

        var redPaint: Paint = Paint()
        var greenPaint: Paint = Paint()
        var bluePaint: Paint = Paint()
        var blackPaint: Paint = Paint()

        bluePaint.color = Color.BLUE
        redPaint.color = Color.RED
        greenPaint.color = Color.GREEN
        blackPaint.color = Color.BLACK

        var susceptibleInt = intent.getIntExtra("susceptibleInt", 1)
        val infectedInt = intent.getIntExtra("infectedInt", 1)
        val recoveredInt = intent.getIntExtra("recoveredInt", 1)
        val rNumberIntSlider = intent.getIntExtra("rNumberInt",1)
        val deadNumberInt = intent.getIntExtra("deadNumberInt",1)

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
        for(i in 1..deadNumberInt){
            balls += Ball((0..1000).random().toFloat(), (0..1800).random().toFloat(), 1000,1800, blackPaint, "dead")
        }
        val susceptibleNumberChanging: TextView = findViewById(R.id.susceptibleNumberChanging)
        val infectedNumberChanging: TextView = findViewById(R.id.infectedNumberChanging)
        val recoveredNumberChanging: TextView = findViewById(R.id.recoveredNumberChanging)
        val deadNumberChanging: TextView = findViewById(R.id.deadNumberChanging)

        val animationThread = Thread {
            try {
                var startTime: Long
                var endTime: Long
                while (true) {
                    startTime = System.currentTimeMillis()

                    (findViewById<View>(R.id.ball) as BallView).parseBallsData(balls, susceptibleInt, infectedInt, recoveredInt, rNumberIntSlider, deadNumberInt)
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


        val animationThread1 = Thread {
            try {
                var startTime: Long
                var endTime: Long
                while (true) {
                    startTime = System.currentTimeMillis()

                    runOnUiThread {
                        susceptibleNumberChanging.text = ((findViewById<View>(R.id.ball) as BallView).susceptibleIntUpdater).toString()
                        infectedNumberChanging.text = ((findViewById<View>(R.id.ball) as BallView).infectedIntUpdater).toString()
                        recoveredNumberChanging.text = ((findViewById<View>(R.id.ball) as BallView).recoveredIntUpdater).toString()
                        deadNumberChanging.text = ((findViewById<View>(R.id.ball) as BallView).deadIntUpdater).toString()
                    }


                    endTime = System.currentTimeMillis()
                    var time = 16-(endTime-startTime)
                    if (time>0){
                        Thread.sleep(time)
                    }
                    else{
                        Thread.sleep(150)
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        animationThread1.start()


    }
}