package com.yuliyang.gradleallinone

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class XForMode @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        View(context, attrs, defStyleAttr) {

    val paint by lazy {
        Paint().apply {
            style = Paint.Style.FILL
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val layer = canvas.saveLayer(0f, 0f, 300f, 300f, paint, Canvas.ALL_SAVE_FLAG)
//绘制背景图片
        paint.color = Color.RED
//        paint.shader = RadialGradient(0f, 0f, 150f
//                , intArrayOf(Color.TRANSPARENT, Color.WHITE, Color.WHITE, Color.TRANSPARENT)
//                , floatArrayOf(0.1f, 0.4f, 0.8f, 1f), Shader.TileMode.CLAMP)
        canvas.drawCircle(150f, 150f, 150f, paint)
//设置 xformode 模式
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
//绘制矩形
        paint.color = Color.BLUE
        canvas.drawCircle(150f, 150f, 100f, paint)
//最后设置为空
        paint.xfermode = null
        canvas.restoreToCount(layer)

    }
}