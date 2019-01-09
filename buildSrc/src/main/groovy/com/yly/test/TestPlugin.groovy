package com.yly.test

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('testTask') << {
            println "Hello gradle plugin"
        }
    }
}