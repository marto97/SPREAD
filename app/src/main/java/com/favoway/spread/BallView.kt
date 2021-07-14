package com.favoway.spread

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import kotlin.math.abs

class BallView : View {

    private var balls: Array<Ball> = arrayOf()
    private var susceptibleInt = 1
    private var infectedInt = 1
    private var recoveredInt = 1
    private var rNumberIntSlider = 1

    private var bluePaint: Paint = Paint()
    private var redPaint: Paint = Paint()
    private var greenPaint: Paint = Paint()

    public var susceptibleIntUpdater = 1
    public var infectedIntUpdater = 1
    public var recoveredIntUpdater = 1

    constructor(context: Context?) : super(context) {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
       // bluePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        bluePaint.color = Color.BLUE

        redPaint.color = Color.RED
        greenPaint.color = Color.GREEN
    }

    fun parseBallsData(_balls: Array<Ball>, _susceptibleInt: Int, _infectedInt: Int, _recoveredInt: Int, _rNumberIntSlider:Int){
        susceptibleInt = _susceptibleInt
        infectedInt = _infectedInt
        recoveredInt = _recoveredInt
        rNumberIntSlider = _rNumberIntSlider

        balls = _balls
    }

    fun getData(){
        infectedInt
    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)

        val sum = susceptibleInt+infectedInt+recoveredInt-1

        for(i in 0..sum){
            balls[i].draw(canvas)

            for(j in 0..sum){
                if (Math.abs(balls[i].xPos-balls[j].xPos) <rNumberIntSlider && Math.abs(balls[i].yPos-balls[j].yPos)<rNumberIntSlider) {
                //    balls[i].paint = redPaint
                   //
                    //println(balls[i].xPos)
                    if ((balls[i].state=="susceptible" && balls[j].state=="infected")||(balls[i].state=="infected" && balls[j].state=="susceptible")){
                        balls[i].paint = redPaint
                        balls[i].state = "infected"
                        balls[j].paint = redPaint
                        balls[j].state = "infected"
                    }
                    if ((balls[i].state=="recovered" && balls[j].state=="infected")||(balls[i].state=="infected" && balls[j].state=="recovered")){
                        balls[i].paint = greenPaint
                        balls[i].state = "recovered"
                        balls[j].paint = greenPaint
                        balls[j].state = "recovered"
                    }
                }
            }
        }

       // println(balls[2].getxPos());
      // val test: TextView = findViewById(R.id.susceptibleNumberChanging)

        susceptibleIntUpdater = balls.filter { s -> s.state == "susceptible" }.size
        infectedIntUpdater = balls.filter { s -> s.state == "infected" }.size
        recoveredIntUpdater = balls.filter { s -> s.state == "recovered" }.size
    }

}