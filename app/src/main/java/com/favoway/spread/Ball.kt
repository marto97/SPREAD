package com.favoway.spread

import android.graphics.Canvas
import android.graphics.Paint


class Ball (_xPos: Float, _yPos: Float, _width: Int, _height: Int, _paint: Paint){
    // property (data member)
    private var xPos: Float = _xPos
    private var yPos: Float = _yPos
    private var width = _width
    private var height = _height
    private var vX = 10F
    private var vY = 10F

    private val paint: Paint = _paint

    private var ballRadius: Float = 10F

    private fun moveBall() {
        xPos += vX
        yPos += vY

        if(xPos > width - ballRadius) {   //Ball exited the right margin
            val overshoot = xPos - (width - ballRadius)
            xPos -= overshoot * 2
            vX = -vX

        } else if (xPos < ballRadius) {   //Ball exited the left border
            val overshoot = ballRadius - xPos
            xPos += overshoot * 2
            vX = -vX
        }

        if(yPos > height - ballRadius) {  //Ball exited below
            val overshoot = yPos - (height - ballRadius)
            yPos -= overshoot * 2
            vY = -vY

        } else if(yPos < ballRadius) {    //Ball exited above
            val overshoot = ballRadius - yPos
            yPos += overshoot * 2
            vY = -vY
        }
    }

    fun draw(canvas: Canvas?){
        moveBall()
        canvas!!.drawCircle(xPos, yPos, ballRadius, paint)
    }
}