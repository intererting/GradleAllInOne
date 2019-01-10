package com.yly.test

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class TestTask extends DefaultTask {

    TestTask() {
        outputs.upToDateWhen { false }
    }

    @TaskAction
    format() {
        println "================================================"
        println new Date().format(project.formater.dateTimeFormat)
    }
}