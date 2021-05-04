package com.example.spread

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class Graph @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint()
    private var circleX : Float
    private var circleY: Float

    init {
        paint.isFilterBitmap = true
        paint.isAntiAlias = true
        paint.color = Color.GREEN
        circleX = (100f * Math.random()).toFloat()
        circleY = 100f
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)



        val blackCircle = canvas?.drawCircle(circleX, circleY, 50f, paint)
        blackCircle
        canvas?.drawCircle(450f, 500f, 50f, paint)
        canvas?.drawCircle(300f, 400f, 50f, paint)

    }

    

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        circleX = event!!.x
        circleY = event!!.y
        invalidate()
        return true
    }
}