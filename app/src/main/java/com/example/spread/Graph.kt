package com.example.spread

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Graph @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint: Paint = Paint()
        canvas?.drawCircle(400f, 600f, 50f, paint)
        canvas?.drawCircle(450f, 500f, 50f, paint)
        canvas?.drawCircle(300f, 400f, 50f, paint)

    }
}