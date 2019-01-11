package com.yuliyang.gradleallinone

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.TextView

class ShimmerTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : TextView(context, attrs, defStyleAttr) {

    var progress = 0f
    val shimmerWidth = 80f

    init {
        paint.textSize = 60f
    }

    override fun onDraw(canvas: Canvas) {
        val sc = canvas.saveLayerAlpha(0f, 0f, width.toFloat(), height.toFloat(), 255, Canvas.ALL_SAVE_FLAG)
        super.onDraw(canvas)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
        canvas.drawBitmap(getBitmap(), -shimmerWidth + progress * (width + shimmerWidth), 0f, paint)
        paint.xfermode = null

        canvas.restoreToCount(sc)
    }

    init {
        val animator = ObjectAnimator.ofFloat(this, "progress", 0f, 1f)
        animator.addUpdateListener { postInvalidate() }
        animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = 5000
        animator.start()

    }

    private fun getBitmap(): Bitmap {
        val paint = Paint()
        paint.color = Color.RED
        val bitmapB = Bitmap.createBitmap(shimmerWidth.toInt(), measuredHeight, Bitmap.Config.ARGB_8888);
        // 建立对应 bitmap 的画布

        val canvasB = Canvas(bitmapB);
        canvasB.drawRect(
                0f, 0f, shimmerWidth, measuredHeight.toFloat(), paint
        )
        return bitmapB
    }
}