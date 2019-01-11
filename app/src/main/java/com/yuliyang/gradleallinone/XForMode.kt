package com.yuliyang.gradleallinone

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet


@RequiresApi(Build.VERSION_CODES.KITKAT)
class XForMode @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatImageView(context, attrs, defStyleAttr) {

    val paint by lazy {
        Paint().apply {
            //            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

//    lateinit var bitmapA: Bitmap
//    lateinit var bitmapB: Bitmap

    //    init {
//        val drawableA = resources.getDrawable(R.drawable.test1)
//        drawableA.bounds = Rect(0, 0, 300, 300)
//        // 建立对应 bitmap
//        bitmapA = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
//        // 建立对应 bitmap 的画布
//        val canvas = Canvas(bitmapA);
//        // 把 drawable 内容画到画布中
//        drawableA.draw(canvas);
//
////        val drawableB = resources.getDrawable(R.drawable.test2)
////        drawableB.bounds = Rect(0, 0, 150, 150)
//        // 建立对应 bitmap
//        bitmapB = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
//        // 建立对应 bitmap 的画布
//
//        val canvasB = Canvas(bitmapB);
//        canvasB.drawCircle(
//                300f, 300f, 300f, paint
//        )
//        // 把 drawable 内容画到画布中
////        drawableB.draw(canvasB);
//    }
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val sc = canvas.saveLayerAlpha(0f, 0f, width.toFloat(), height.toFloat(), 255, Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.test), 0f, 0f, Paint())

        //绘制背景图片

//最后设置为空
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas.drawBitmap(getBitmap(), 0f, 0f, paint)

        canvas.restoreToCount(sc)


    }

//    override fun onDraw(canvas: Canvas) {
////        val layer = canvas.saveLayer(0f, 0f, 600f, 600f, paint, Canvas.ALL_SAVE_FLAG)
//
//        val bitmapA = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        val canvasA = Canvas(bitmapA);
//        drawable.bounds = Rect(0, 0, width, height)
//        drawable.draw(canvasA)
//
//        paint.reset()
//        paint.isFilterBitmap = false
//        paint.xfermode = null
//        canvas.drawBitmap(bitmapA, 0f, 0f, null)
//
//        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
//        canvasA.drawBitmap(getBitmap(), 0f, 0f, paint)
//
//
////        canvas.restoreToCount(layer)
//    }

    private fun getBitmap(): Bitmap {
        val paint = Paint()
        paint.color = Color.BLACK
        val bitmapB = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // 建立对应 bitmap 的画布

        val canvasB = Canvas(bitmapB);
        canvasB.drawCircle(
            200f, 200f, 200f, paint
        )
        return bitmapB
    }

}