package com.example.spread

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BallView : View {

    private var balls: Array<Ball> = arrayOf()
    private var susceptibleInt = 1
    private var infectedInt = 1
    private var recoveredInt = 1

    private var bluePaint: Paint = Paint()
    private var redPaint: Paint = Paint()
    private var greenPaint: Paint = Paint()

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
        bluePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        bluePaint.color = Color.argb(0xFF, 0x91, 0xD8, 0xFF)

        redPaint.color = Color.RED
        greenPaint.color = Color.GREEN
    }

    fun parseBallsData(_balls: Array<Ball>, _susceptibleInt: Int, _infectedInt: Int, _recoveredInt: Int){
        susceptibleInt = _susceptibleInt
        infectedInt = _infectedInt
        recoveredInt = _recoveredInt

        balls = _balls
    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)

        val sum = susceptibleInt+infectedInt+recoveredInt-1

        for(i in 0..sum){
            balls[i].draw(canvas)
        }

    }

}