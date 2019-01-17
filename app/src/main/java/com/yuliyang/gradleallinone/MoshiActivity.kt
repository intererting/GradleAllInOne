package com.yuliyang.gradleallinone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val json = """
      {"name":null,"age":21}
  """.trimIndent()

        val moshi = Moshi.Builder().add(NullToStringAdapter()).build()
        val jsonAdapter = moshi.adapter(Person::class.java)
        val blackjackHand = jsonAdapter.nullSafe().fromJson(json)
        System.out.println(blackjackHand)
    }
}

data class Person(@NullToString var name: Int?, var age: Int) {
    override fun toString(): String {
        return "$name  $age"
    }
}