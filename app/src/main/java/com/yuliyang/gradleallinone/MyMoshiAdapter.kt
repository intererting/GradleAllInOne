package com.yuliyang.gradleallinone

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson


//只能用于value
//class MyMoshiAdapter {
//    @ToJson
//    fun toJson(person: Person): String {
//        return person.name
//    }
//
//    @FromJson
//    fun fromJson(person: String): Person {
//        return Person("hahaha", 211)
//    }
//}

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class NullToString

/** Converts strings like #ff0000 to the corresponding color ints.  */
internal class NullToStringAdapter {
    @ToJson
    fun toJson(@NullToString obj: Int?): String {
        return "1"
    }

    @FromJson
    @NullToString
    fun fromJson(json: String?): Int {
        return 2
    }
}