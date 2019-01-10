package com.yly.test

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def task = project.task('testTask') {
            print(project.rootDir)
        }
//        task.dependsOn("assembleDebug")
    }
}