package com.yly.test

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.plugins.ExtensionsStorage

class TestPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def android = project.extensions.android
//        android.registerTransform(new TestTransform())

        android.applicationVariants.all { variant ->
//            variant.javaCompile.doLast {
//                println "xxxxxxxxxxxxxxzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"
//            }
        }

        def taskAuto = project.task("testTaskAuto") {
//            println project.rootDir
//            def number = 1
//            def lazyString = "${-> number}"
//            number = 3
//            println "3" == lazyString(3)

//            def mClosure = { it }
//            println mClosure(3)

            android.applicationVariants.all { variant ->
//                def variantName = variant.name.capitalize()
//                println variantName
                println variant
            }

//            android.buildTypes.all { buildType ->
//                def buildTypeName = buildType.name.capitalize()
//                println buildTypeName
//            }
        }
        def task = project.task("testTask") << {
            println android.defaultConfig.minSdkVersion.mApiLevel
        }

        task.dependsOn("assembleDebug")
    }
}