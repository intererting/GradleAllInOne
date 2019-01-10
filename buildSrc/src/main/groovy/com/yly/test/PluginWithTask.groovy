package com.yly.test

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginWithTask implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.afterEvaluate {
            def android = project.extensions.android
            android.buildTypes.all { buildType ->
                def buildTypeName = buildType.name.capitalize()

                def mTask = project.task("formatDateTime_${buildTypeName}", type: TestTask)
                mTask.dependsOn "assemble${buildTypeName}"
            }
        }
    }
}