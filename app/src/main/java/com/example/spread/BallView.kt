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

    private var ballPaint: Paint = Paint()
    private var redBallPaint: Paint = Paint()

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
        ballPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        (ballPaint).color = Color.argb(0xFF, 0x91, 0xD8, 0xFF)

        redBallPaint.color = Color.RED
    }

    fun parseBallsData(_susceptibleInt: Int){
        susceptibleInt = _susceptibleInt

        for(i in 1..susceptibleInt){
            balls += Ball((0..1000).random().toFloat(), (0..1800).random().toFloat(), 1000,1800, ballPaint)
        }
    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)

        for(i in 1..susceptibleInt){
            balls[i].draw(canvas)
        }

    }

}