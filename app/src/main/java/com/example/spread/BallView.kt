package com.example.spread

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class BallView : View {

    var ballCount = 1

    var ballX = 150F
    var ballY = 200F
    var ballRad = 50F

    var vX = 10F
    var vY = 10F

    var ballXX = 300F

    var ballPaint: Paint = Paint()

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
        (ballPaint as Paint).color = Color.argb(0xFF, 0x91, 0xD8, 0xFF)
    }


    /**
     * Changes the velocity of the ball.
     *
     * @param vx: Int delta x
     * @param vy: Int delta y
     */
    fun addVelocity(dx: Float, dy: Float) {
        vX += dx
        vY += dy
    }

    fun changeBallNumber(count: Int){
        ballCount = count
    }

    /**
     * Moves the ball around the view.
     */
    fun moveBall() {
        ballX += vX
        ballY += vY

        if(ballX > width - ballRad) {   //Ball exited the right margin
            val overshoot = ballX - (width - ballRad)
            ballX -= overshoot * 2
            vX = -vX

        } else if (ballX < ballRad) {   //Ball exited the left border
            val overshoot = ballRad - ballX
            ballX += overshoot * 2
            vX = -vX
        }

        if(ballY > height - ballRad) {  //Ball exited below
            val overshoot = ballY - (height - ballRad)
            ballY -= overshoot * 2
            vY = -vY
        } else if(ballY < ballRad) {    //Ball exited above
            val overshoot = ballRad - ballY
            ballY += overshoot * 2
            vY = -vY
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawCircle(ballX, ballY, ballRad, ballPaint)
        canvas!!.drawCircle(ballXX, ballY, ballRad, ballPaint)

        println(ballCount)
        println("TEST TEST TEST TEST")
        for(i in 1..ballCount){
            canvas!!.drawCircle((i*200).toFloat(), (i*200).toFloat(), ballRad, ballPaint)

        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.action == MotionEvent.ACTION_DOWN) {
            val xDistance = event.x - ballX
            val yDistance = event.y - ballY

            val deltaX = -xDistance / 25
            val deltaY = -yDistance / 25

            addVelocity(deltaX, deltaY)
        }

        return super.onTouchEvent(event)
    }


}