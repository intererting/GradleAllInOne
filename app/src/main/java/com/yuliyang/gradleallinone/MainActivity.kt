package com.yuliyang.gradleallinone

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.TextView
import android.widget.ViewSwitcher
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val testMap: (a: Int) -> String = { a -> "haha" }
//        val testMap = { a: Int, b: Int -> "haha" }

        textSwitcher.setFactory {
            val tv = TextView(this@MainActivity)
            tv.textSize = 40f
            // 字体颜色品红
            tv.setTextColor(Color.MAGENTA)
            tv
        }

    }

    override fun onResume() {
        super.onResume()
        GlobalScope.launch(Dispatchers.IO) {
            repeat(1000) {
                GlobalScope.launch(Dispatchers.Main) {
                    textSwitcher.setText(System.currentTimeMillis().toString())
                }
                delay(3000)
            }
        }
    }

}
