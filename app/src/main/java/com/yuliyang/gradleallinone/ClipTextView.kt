package com.yuliyang.gradleallinone

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import android.widget.ViewAnimator

class ClipTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    val testText = "这是一段测试文字"
    val textBouds = Rect()
    val MAX_PROGRESS = 100f
    var progress = 0

    val paint by lazy {
        Paint().apply {
            textSize = 100f
            isAntiAlias = true
        }
    }

    init {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        paint.getTextBounds(testText, 0, testText.length, textBouds)
        setMeasuredDimension(textBouds.width(), textBouds.height() + 500)
    }

    init {
        val animator = ObjectAnimator.ofInt(this, "progress", 0, 100)
        animator.addUpdateListener { postInvalidate() }
        animator.duration = 10000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.start()

    }

    override fun onDraw(canvas: Canvas) {
        val tWidth = textBouds.width().toFloat()
        val tHeight = textBouds.height().toFloat()
        paint.color = Color.WHITE
        canvas.drawText(testText, 0f, tHeight, paint)
        paint.color = Color.BLACK

        val progressWidth = (progress / MAX_PROGRESS) * tWidth;
        canvas.save();
        canvas.clipRect(0f, 0f, progressWidth, measuredHeight.toFloat());
        canvas.drawText(testText, 0f, tHeight, paint);
        canvas.restore();
    }

}