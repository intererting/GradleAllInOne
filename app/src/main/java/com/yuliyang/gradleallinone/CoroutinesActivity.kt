package com.yuliyang.gradleallinone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        val a = { -> println("xxxxxxxxxx") }
        a.test()

        GlobalScope.launch(Dispatchers.Main) {
            //            println("before delay ${Thread.currentThread()}")
            delay(10000)
            println("after delay ${Thread.currentThread()}")
        }

        println("out ${Thread.currentThread()}")

        val list = arrayListOf(1, 2, 3, 4, 5)
        val result = list.binarySearch sc@{
            return@sc it - 4
        }
        println(result)

        println(3.4 == 3.4)
    }
}


fun (() -> Unit).test() {
//    invoke()
}