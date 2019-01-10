package com.yly.test

import org.gradle.api.Plugin
import org.gradle.api.Project

class LearnPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.afterEvaluate {
            println 'LearnPlugin  afterEvaluate'

            def android = project.extensions.android

            android.buildTypes.all { buildType ->
                def buildTypeName = buildType.name.capitalize()
                println "buildTypeName  $buildTypeName"
            }
        }
    }
}